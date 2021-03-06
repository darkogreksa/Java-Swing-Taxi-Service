package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import korisnici.Korisnik;
import korisnici.Vozaci;

public class GlavniProzor extends JFrame {

	private JMenuBar mainMenu;
	private JMenu musterijeMenu;
	private JMenuItem zakazivanjeVoznje;
	private JMenuItem rezervisaneVoznje;
	
	private JMenu vozaciMenu;
	private JMenuItem prikazVozaca;
	
	private JMenu dispeceriMenu;
	private JMenuItem dodajKorisnika;
	
	private Korisnik ulogovaniKorisnik;

	public GlavniProzor(Korisnik ulogovaniKorisnik) {
		setTitle("Fake Taxi");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		initGUI();
		initActions();
	}

	public GlavniProzor() {

	}

	private void initActions() {

		zakazivanjeVoznje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZakazivanjeProzor zakazivanje = new ZakazivanjeProzor();
				zakazivanje.setVisible(true);

			}
		});
		
		rezervisaneVoznje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZakazaneVoznjeProzor rezervisane = new ZakazaneVoznjeProzor();
				rezervisane.setVisible(true);

			}
		});
		
		dodajKorisnika.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeKorisnikaProzor dodajKorisnika = new DodavanjeKorisnikaProzor();
				dodajKorisnika.setVisible(true);

			}
		});
		
		prikazVozaca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazVozacaProzor prikazVozaca = new PrikazVozacaProzor();
				prikazVozaca.setVisible(true);

			}
		});

	}

	private void initGUI() {
		mainMenu = new JMenuBar();
		musterijeMenu = new JMenu("Musterije");
		vozaciMenu = new JMenu("Vozaci");
		dispeceriMenu = new JMenu("Dispeceri");
		
		mainMenu.add(musterijeMenu);
		mainMenu.add(vozaciMenu);
		mainMenu.add(dispeceriMenu);
		
		zakazivanjeVoznje = new JMenuItem("Zakazivanje voznje");
		rezervisaneVoznje = new JMenuItem("Rezervisani prevozi");
		
		musterijeMenu.add(rezervisaneVoznje);
		musterijeMenu.add(zakazivanjeVoznje);
		
		prikazVozaca = new JMenuItem("Spisak vozaca");
		vozaciMenu.add(prikazVozaca);
		//vozaciMenu.add(rezervisaneVoznje);
		dodajKorisnika = new JMenuItem("Dodaj Korisnika");
		dispeceriMenu.add(dodajKorisnika);
		
		
		setJMenuBar(mainMenu);

	}

	public Korisnik getUlogovaniKorisnik() {
		return ulogovaniKorisnik;
	}

	public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
		this.ulogovaniKorisnik = ulogovaniKorisnik;
	}

}
