package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import korisnici.Vozaci;
import taksiSluzba.Vozilo;
import taksiSluzba.Voznje;



public class ZakazaneVoznjeProzor extends JFrame {
	
	private JToolBar tbTulbar;
	private JButton btnRezervisi;
	private JButton btnIzmeni;
	private JScrollPane spSkrol;
	private JTable tblVoznje;
	
	public ZakazaneVoznjeProzor() {
		setTitle("Zakazane voznje");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(800, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		initGUI();
		initActions();
	}

	private void initActions() {

		btnRezervisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZakazivanjeProzor zakazivanje = new ZakazivanjeProzor();
				zakazivanje.setVisible(true);
			}
		});
		
	}

	public ArrayList<Voznje> ucitajVoznje() {
		ArrayList<Voznje> zakazaneVoznje = new ArrayList<Voznje>();
		try {
			File voznjeFile = new File("src/txt/voznje");
			BufferedReader br = new BufferedReader(new FileReader(voznjeFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String imePrezimeMusterije = split[0];
				String datumPolaska = split[1];
				String adresaPolaska = split[2];
				String nacinPorudzbine = split[3];
				String vozac = split[4];
				String dispecer = split[5];
				String vrstaVozila = split[6];
				String napomena = split[7];
				
				Voznje novaVoznja = new Voznje(imePrezimeMusterije, datumPolaska, adresaPolaska, nacinPorudzbine, vozac, dispecer, vrstaVozila, napomena);
				zakazaneVoznje.add(novaVoznja);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(zakazaneVoznje);
		return zakazaneVoznje;
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/ikonice/rezervisi.png"));
		btnRezervisi = new JButton(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/ikonice/izmeni.png"));
		btnIzmeni = new JButton(editIcon);
		
		tbTulbar = new JToolBar();
		tbTulbar.add(btnRezervisi);
		tbTulbar.add(btnIzmeni);
		spSkrol = new JScrollPane();

		ArrayList<Voznje> zakazaneVoznje = ucitajVoznje();
		//System.out.println(zakazaneVoznje);
	//	System.out.println(zakazaneVoznje.size());

		String[] zaglavlje = new String[] {"Musterija", "Datum", "Adresa", "Rezervacija", "Vozac", "Dispecer", "Vrsta vozila", "Napomena"};
		Object[][] prikaz = new Object[zakazaneVoznje.size()][zaglavlje.length];	
		int a = 0;
		for (int i = 0; i < zakazaneVoznje.size(); i++){
			Voznje v=zakazaneVoznje.get(i);
				prikaz[i][0] = v.getImePrezimeMusterije();
				prikaz[i][1] = v.getDatumPolaska();
				prikaz[i][2] = v.getAdresaPolaska();
				prikaz[i][3] = v.getNacinPorudzbine();
				prikaz[i][4] = v.getVozac();
				prikaz[i][5] = v.getDispecer();
				prikaz[i][6] = v.getVrstaVozila();
				prikaz[i][7] = v.getNapomena();
				
			}
		
		
		DefaultTableModel tableModel = new DefaultTableModel(prikaz,zaglavlje);
		tblVoznje = new JTable(tableModel);
		tblVoznje.setRowSelectionAllowed(true);
		tblVoznje.setColumnSelectionAllowed(true);
		tblVoznje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblVoznje.setDefaultEditor(Object.class, null);
		
		JScrollPane tableScroll = new JScrollPane(tblVoznje);
		add(spSkrol);
		add(tbTulbar, BorderLayout.NORTH);
		add(tableScroll, BorderLayout.CENTER);
	}
}
