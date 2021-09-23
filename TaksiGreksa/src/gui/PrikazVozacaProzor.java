package gui;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import korisnici.Vozaci;
import taksiSluzba.Voznje;

public class PrikazVozacaProzor extends JFrame {
	
	private JToolBar tbTulbar;
	private JButton btnRezervisi;
	private JButton btnIzmeni;
	private JScrollPane spSkrol;
	private JTable tblVoznje;
	
	public PrikazVozacaProzor() {
		setTitle("Vozaci");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(800, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		initGUI();
		initActions();
	}

	private ArrayList<Vozaci> ucitajVozace()
	{
		ArrayList<Vozaci> vozaci = new ArrayList<Vozaci>();
		try {
			File vozaciFile = new File("src/txt/vozaci");
			BufferedReader br = new BufferedReader(new FileReader(vozaciFile));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				String adresa = split [3];
				String pol = split[4];
				String telefon = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				String brojClanseKarte = split[9];
				String vozilo = split[10];
				Vozaci noviVozac = new Vozaci(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka, plata, brojClanseKarte, vozilo);
				vozaci.add(noviVozac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vozaci;
	}
	private void initActions() {
		// TODO Auto-generated method stub
		
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

		ArrayList<Vozaci> vozaci = ucitajVozace();
		String[] zaglavlje = new String[] {"Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisnicko ime", "Lozinka", "Plata", "Vozilo"};
		Object[][] prikaz = new Object[vozaci.size()][zaglavlje.length];	
		int a = 0;
		for (int i = 0; i < vozaci.size(); i++){
			Vozaci v=vozaci.get(i);
				prikaz[i][0] = v.getIme();
				prikaz[i][1] = v.getPrezime();
				prikaz[i][2] = v.getJmbg();
				prikaz[i][3] = v.getAdresa();
				prikaz[i][4] = v.getPol();
				prikaz[i][5] = v.getKorisnickoIme();
				prikaz[i][6] = v.getLozinka();
				prikaz[i][7] = v.getPlata();
				prikaz[i][8] = v.getVozilo();
				
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
