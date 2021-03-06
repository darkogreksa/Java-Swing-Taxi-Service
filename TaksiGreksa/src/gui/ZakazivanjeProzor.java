package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import korisnici.Dispecer;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;
import taksiSluzba.Vozilo;

public class ZakazivanjeProzor extends JFrame {

	private JLabel lblImePrezimeMusterije;
	private JTextField txtImePrezimeMusterije;

	private JLabel lblDatumPorudzbine;
	private JDatePanelImpl pnlDatumPorudzbine;

	private JLabel lblAdresaPolaska;
	private JTextField txtAdresaPolaska;

	private JLabel lblVozac;
	private JComboBox cbVozac;

	private JComboBox cbDispecer;
	private JLabel lblDispecer;

	private JLabel lblVozilo;
	private JComboBox cbVozilo;

	private JRadioButton rbMobilnaAplikacija;
	private JRadioButton rbTelefonskiPoziv;
	private ButtonGroup bgPorudzbina;

	private JLabel lblNapomena;
	private JTextField txtNapomena;

	private JButton btnPotvrdi;

	public ZakazivanjeProzor() {
		setTitle("Zakazivanje voznje");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(400, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
	}

	private void initActions() {
		rbMobilnaAplikacija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rbMobilnaAplikacija.addItemListener(evt -> {
					cbVozac.setEnabled(evt.getStateChange() == ItemEvent.SELECTED);
					txtNapomena.setEnabled(evt.getStateChange() == ItemEvent.SELECTED);
				});
			}
		});
		rbTelefonskiPoziv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rbTelefonskiPoziv.addItemListener(evt -> {
					cbDispecer.setEnabled(evt.getStateChange() == ItemEvent.SELECTED);
				});
			}
		});

		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				File fajlVoznje = new File("src/txt/voznje");
				try {
					FileWriter fw = new FileWriter(fajlVoznje, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw, true);
					String datumString = "";
					if (pnlDatumPorudzbine != null) {
						Date selektovanDatum = (Date) pnlDatumPorudzbine.getModel().getValue();
						DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
						datumString = df.format(selektovanDatum);
					}
					String nacinPorudzbine = "";
					if (rbMobilnaAplikacija.isSelected()) {
						nacinPorudzbine = "mobilnaAplikacija";
						String imeVozaca = "";
						Vozaci vozac = (Vozaci) cbVozac.getSelectedItem();
						if(vozac != null)
						{
							imeVozaca = vozac.getIme();
						}
						String izabranoVozilo = "";
						if(cbVozilo != null)
						{
							izabranoVozilo = (String) cbVozilo.getSelectedItem();
						}
						pw.println(txtImePrezimeMusterije.getText() + "|" + datumString + "|"
								+ txtAdresaPolaska.getText() + "|" + nacinPorudzbine + "|" + imeVozaca + "|"
								+ izabranoVozilo + "|" + txtNapomena.getText());
					}
					if (rbTelefonskiPoziv.isSelected()) {
						nacinPorudzbine = "telefonskiPoziv";
						Dispecer dispecer = (Dispecer) cbDispecer.getSelectedItem();
						Vozilo vozilo = (Vozilo) cbVozilo.getSelectedItem();
						pw.println(txtImePrezimeMusterije.getText() + "|" + datumString + "|"
								+ txtAdresaPolaska.getText() + "|" + nacinPorudzbine + "|"
								+ dispecer.getTelefonskoOdeljenje() + "|" + vozilo.getVrstaVozila());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	}

	public ArrayList<Vozilo> ucitajVozila() {
		ArrayList<Vozilo> vozila = new ArrayList<Vozilo>();
		try {
			File automobiliFile = new File("src/txt/automobili");
			BufferedReader br = new BufferedReader(new FileReader(automobiliFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String model = split[0];
				String proizvodjac = split[1];
				String godinaProizvodnjeStr = split[2];
				int godinaProizvodnje = Integer.parseInt(godinaProizvodnjeStr);
				String registracija = split[3];
				String brojVozilaStr = split[4];
				int brojVozila = Integer.parseInt(brojVozilaStr);
				String vrstaVozila = split[5];
				Vozilo novoVozilo = new Vozilo(model, proizvodjac, godinaProizvodnje, registracija, brojVozila,
						vrstaVozila);
				vozila.add(novoVozilo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vozila;
	}

	public class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "dd.MM.yyyy.";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		lblImePrezimeMusterije = new JLabel("Ime i prezime musterije");
		txtImePrezimeMusterije = new JTextField(20);

		lblDatumPorudzbine = new JLabel("Datum zakazivanja voznje:");
		UtilDateModel model = new UtilDateModel();
		model.setDate(20, 04, 2014);
		Properties datum = new Properties();
		datum.put("text.today", "Today");
		datum.put("text.month", "Month");
		datum.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, datum);
		JDatePickerImpl pnlDatumPorudzbine = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		lblAdresaPolaska = new JLabel("Adresa polaska");
		txtAdresaPolaska = new JTextField(20);

		cbDispecer = new JComboBox();
		lblDispecer = new JLabel("Dispecer sa kojim ste razgovarali");

		cbVozac = new JComboBox();
		lblVozac = new JLabel("Izaberite vozaca");

		lblVozilo = new JLabel("Vrsta vozila");
		cbVozilo = new JComboBox();

		rbMobilnaAplikacija = new JRadioButton("Mobilna aplikacija");
		rbTelefonskiPoziv = new JRadioButton("Telefonski poziv");
		bgPorudzbina = new ButtonGroup();

		lblNapomena = new JLabel("Napomena");
		txtNapomena = new JTextField(20);

		btnPotvrdi = new JButton("Potvrdi");

		add(lblImePrezimeMusterije);
		add(txtImePrezimeMusterije);

		add(lblDatumPorudzbine);
		add(pnlDatumPorudzbine);

		add(lblAdresaPolaska);
		add(txtAdresaPolaska);

		add(rbMobilnaAplikacija);
		add(rbTelefonskiPoziv);

		add(lblVozac);
		add(cbVozac);

		add(lblDispecer);
		add(cbDispecer);

		add(lblVozilo);
		add(cbVozilo);

		ArrayList<Vozilo> vozila = ucitajVozila();
		for (Vozilo v : vozila) {
			cbVozilo.addItem(v.getVrstaVozila());
		}

		bgPorudzbina = new ButtonGroup();
		bgPorudzbina.add(rbMobilnaAplikacija);
		bgPorudzbina.add(rbTelefonskiPoziv);

		add(lblNapomena);
		add(txtNapomena);

		add(btnPotvrdi, "split2");

		// default set on startup
		rbMobilnaAplikacija.setSelected(true);

	}

}
