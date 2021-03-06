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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import korisnici.Dispecer;
import korisnici.Musterije;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;
import taksiSluzba.Vozilo;

public class DodavanjeKorisnikaProzor extends JFrame {

	private JLabel lblVrstaKorisnika;
	private JComboBox cbVrstaKorisnika;

	private JLabel lblImeKorisnika;
	private JTextField txtImeKorisnika;

	private JLabel lblPrezime;
	private JTextField txtPrezime;

	private JLabel lblJmbg;
	private JTextField txtJmbg;

	private JLabel lblAdresa;
	private JTextField txtAdresa;

	private JLabel lblPol;
	private JComboBox cbPol;

	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;

	private JLabel lblLozinka;
	private JTextField txtLozinka;

	private JLabel lblPlata;
	private JTextField txtPlata;

	private JLabel lblBrojClanskeKarte;
	private JTextField txtBrojClanskeKarte;

	private JLabel lblVozilo;
	private JComboBox cbVozilo;

	private JLabel lblTelefon;
	private JTextField txtTelefon;

	private JLabel lblTelefonskaLinija;
	private JTextField txtTelefonskaLinija;

	private JLabel lblTelefonskoOdeljenje;
	private JTextField txtTelefonskoOdeljenje;

	private JButton btnDodaj;

	public DodavanjeKorisnikaProzor() {
		setTitle("Dodavanje korisnika");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
	}

	private void initActions() {

		cbVrstaKorisnika.setSelectedIndex(-1);
		cbVrstaKorisnika.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbVrstaKorisnika.getSelectedItem().equals("Musterija")) {
					txtPlata.setEnabled(false);
					txtBrojClanskeKarte.setEnabled(false);
					cbVozilo.setEnabled(false);
					txtTelefonskaLinija.setEnabled(false);
					txtTelefonskoOdeljenje.setEnabled(false);

				}
				if (cbVrstaKorisnika.getSelectedItem().equals("Vozac")) {
					txtTelefonskaLinija.setEnabled(false);
					txtTelefonskoOdeljenje.setEnabled(false);

				}
				if (cbVrstaKorisnika.getSelectedItem().equals("Dispecer")) {
					txtBrojClanskeKarte.setEnabled(false);
					cbVozilo.setEnabled(false);
					

				}
			}

		});
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						if (cbVrstaKorisnika.getSelectedItem().equals("Musterija")) {
						File fajlMusterije = new File("src/txt/musterije");
						FileWriter fw = new FileWriter(fajlMusterije, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw, true);
						pw.println(txtImeKorisnika.getText() + "|" + txtPrezime.getText() + "|" + txtJmbg.getText()
								+ "|" + txtAdresa.getText() + "|" + cbPol.getSelectedItem() + "|" + txtTelefon.getText()
								+ "|" + txtKorisnickoIme.getText() + "|" + txtLozinka.getText() + "|" + "da");
						}
						if (cbVrstaKorisnika.getSelectedItem().equals("Dispecer")) {
							File fajlVozaci = new File("src/txt/dispeceri");
							FileWriter fw1 = new FileWriter(fajlVozaci, true);
							BufferedWriter bw1 = new BufferedWriter(fw1);
							PrintWriter pw1 = new PrintWriter(bw1, true);
							pw1.println(txtImeKorisnika.getText() + "|" + txtPrezime.getText() + "|" + txtJmbg.getText()
									+ "|" + txtAdresa.getText() + "|" + cbPol.getSelectedItem() + "|"
									+ txtTelefon.getText() + "|" + txtKorisnickoIme.getText() + "|"
									+ txtLozinka.getText() + "|" + txtPlata.getText() + "|"
									+ txtTelefonskaLinija.getText() + "|" + txtTelefonskoOdeljenje.getText());
						//} catch (IOException a) {
						//	a.printStackTrace();
						}
						if (cbVrstaKorisnika.getSelectedItem().equals("Vozac")){
							File fajlDispeceri = new File("src/txt/vozaci");
							//try {
								FileWriter fw2 = new FileWriter(fajlDispeceri, true);
								BufferedWriter bw2 = new BufferedWriter(fw2);
								PrintWriter pw2 = new PrintWriter(bw2, true);
								pw2.println(txtImeKorisnika.getText() + "|" + txtPrezime.getText() + "|"+ 
								txtJmbg.getText() + "|" + txtAdresa.getText() + "|" + 
										cbPol.getSelectedItem() + "|" + 
										txtTelefon.getText() + "|" +  
										txtKorisnickoIme.getText() + "|" + txtLozinka.getText() + "|" + txtPlata.getText() + "|" + txtBrojClanskeKarte.getText() + "|" +cbVozilo.getSelectedItem());
							//}catch (IOException a){
						//		a.printStackTrace();
						} 
					} catch (IOException g) {
						g.printStackTrace();
					}
			}
		});
	}

	private ArrayList<Musterije> ucitajMusterije() {
		ArrayList<Musterije> musterije = new ArrayList<Musterije>();
		try {
			File musterijeFile = new File("src/txt/musterije");
			BufferedReader br = new BufferedReader(new FileReader(musterijeFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				String adresa = split[3];
				String pol = split[4];
				String telefon = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				String mobilnaAplikacija = split[8];
				Musterije novaMusterija = new Musterije(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme,
						lozinka, mobilnaAplikacija);
				musterije.add(novaMusterija);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return musterije;
	}

	private ArrayList<Dispecer> ucitajDispecere() {
		ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
		try {
			File dispeceriFile = new File("src/txt/dispeceri");
			BufferedReader br = new BufferedReader(new FileReader(dispeceriFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				String adresa = split[3];
				String pol = split[4];
				String telefon = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				String telefonskaLinija = split[9];
				String telefonskoOdeljenje = split[10];
				Dispecer noviDispecer = new Dispecer(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka,
						plata, telefonskaLinija, telefonskoOdeljenje);
				dispeceri.add(noviDispecer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dispeceri;
	}

	private ArrayList<Vozaci> ucitajVozace() {
		ArrayList<Vozaci> vozaci = new ArrayList<Vozaci>();
		try {
			File vozaciFile = new File("src/txt/vozaci");
			BufferedReader br = new BufferedReader(new FileReader(vozaciFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				String adresa = split[3];
				String pol = split[4];
				String telefon = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				String brojClanseKarte = split[9];
				String vozilo = split[10];
				Vozaci noviVozac = new Vozaci(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka, plata,
						brojClanseKarte, vozilo);
				vozaci.add(noviVozac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vozaci;
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

	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);

		lblVrstaKorisnika = new JLabel("Vrsta korisnika");
		cbVrstaKorisnika = new JComboBox();
		cbVrstaKorisnika.addItem("Musterija");
		cbVrstaKorisnika.addItem("Vozac");
		cbVrstaKorisnika.addItem("Dispecer");

		lblImeKorisnika = new JLabel("Ime");
		txtImeKorisnika = new JTextField(20);

		lblPrezime = new JLabel("Prezime");
		txtPrezime = new JTextField(20);

		lblJmbg = new JLabel("JMBG");
		txtJmbg = new JTextField(20);

		lblAdresa = new JLabel("Adresa");
		txtAdresa = new JTextField(20);

		lblPol = new JLabel("Pol");
		cbPol = new JComboBox();
		cbPol.addItem("M");
		cbPol.addItem("Z");

		lblKorisnickoIme = new JLabel("Korisnicko ime");
		txtKorisnickoIme = new JTextField(20);

		lblLozinka = new JLabel("Lozinka");
		txtLozinka = new JTextField(20);

		lblPlata = new JLabel("Plata");
		txtPlata = new JTextField(20);

		lblBrojClanskeKarte = new JLabel("Broj clanske kartice");
		txtBrojClanskeKarte = new JTextField(20);

		lblVozilo = new JLabel("Vozilo");
		cbVozilo = new JComboBox();

		ArrayList<Vozilo> vozila = ucitajVozila();
		for (Vozilo v : vozila) {
			cbVozilo.addItem(v.getVrstaVozila());
		}

		lblTelefon = new JLabel("Broj telefona");
		txtTelefon = new JTextField(20);

		lblTelefonskaLinija = new JLabel("Telefonska linija");
		txtTelefonskaLinija = new JTextField(20);

		lblTelefonskoOdeljenje = new JLabel("Telefonsko odeljenje");
		txtTelefonskoOdeljenje = new JTextField(20);

		btnDodaj = new JButton("Potvrdi");

		add(lblVrstaKorisnika);
		add(cbVrstaKorisnika);

		add(lblImeKorisnika);
		add(txtImeKorisnika);

		add(lblPrezime);
		add(txtPrezime);

		add(lblJmbg);
		add(txtJmbg);

		add(lblAdresa);
		add(txtAdresa);

		add(lblPol);
		add(cbPol);

		add(lblKorisnickoIme);
		add(txtKorisnickoIme);

		add(lblLozinka);
		add(txtLozinka);

		add(lblPlata);
		add(txtPlata);

		add(lblBrojClanskeKarte);
		add(txtBrojClanskeKarte);

		add(lblVozilo);
		add(cbVozilo);

		add(lblTelefon);
		add(txtTelefon);

		add(lblTelefonskaLinija);
		add(txtTelefonskaLinija);

		add(lblTelefonskoOdeljenje);
		add(txtTelefonskoOdeljenje);

		add(btnDodaj);
	}
}
