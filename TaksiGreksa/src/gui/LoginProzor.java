package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import korisnici.Dispecer;
import korisnici.Korisnik;
import korisnici.Musterije;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;

public class LoginProzor extends JFrame {

	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	private JLabel lblSifra;
	private JPasswordField pfSifra;
	private JButton btnOk;
	private JButton btnPonisti;

	public LoginProzor() {
		setTitle("Prijavljivanje");
		ImageIcon ikonica = new ImageIcon(LoginProzor.class.getResource("/ikonice/faketaxi.png"));
		setIconImage(ikonica.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();

	}

	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		lblKorisnickoIme = new JLabel("Korisnicko ime");
		txtKorisnickoIme = new JTextField(15);
		lblSifra = new JLabel("Sifra");
		pfSifra = new JPasswordField(15);
		btnOk = new JButton("Prijava");
		btnPonisti = new JButton("Odustani");

		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(pfSifra);
		add(new JLabel());
		add(btnOk, "split2");
		add(btnPonisti);
	}

	private ArrayList<Musterije> ucitajMusterije()
	{
		ArrayList<Musterije> musterije = new ArrayList<Musterije>();
		try {
			File musterijeFile = new File("src/txt/musterije");
			BufferedReader br = new BufferedReader(new FileReader(musterijeFile));
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
				String mobilnaAplikacija = split[8];
				Musterije novaMusterija = new Musterije(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka, mobilnaAplikacija);
				musterije.add(novaMusterija);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return musterije;
	}
	
	private ArrayList<Dispecer> ucitajDispecere()
	{
		ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
		try {
			File dispeceriFile = new File("src/txt/dispeceri");
			BufferedReader br = new BufferedReader(new FileReader(dispeceriFile));
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
				String telefonskaLinija = split[9];
				String telefonskoOdeljenje = split[10];
				Dispecer noviDispecer = new Dispecer(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka, plata, telefonskaLinija, telefonskoOdeljenje);
				dispeceri.add(noviDispecer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dispeceri;
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
	
	private ArrayList<Korisnik> ucitajKorisnike()
	{
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		ArrayList<Musterije> musterije = ucitajMusterije();
		ArrayList<Dispecer> dispeceri = ucitajDispecere();
		ArrayList<Vozaci> vozaci = ucitajVozace();
		
		korisnici.addAll(musterije);
		korisnici.addAll(dispeceri);
		korisnici.addAll(vozaci);
		
		return korisnici;
		
		
	}

	private void initActions() {

		btnPonisti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
			}
		});

		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Korisnik> korisnici = ucitajKorisnike();
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				Boolean unetiPrazniPodaci = false;
				if (korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve login podatke", "Greska",
							JOptionPane.WARNING_MESSAGE);
					unetiPrazniPodaci = true;
				}
				if(!unetiPrazniPodaci)
				{
					Boolean ulogovan = false;
					for(Korisnik k : korisnici)
					{
						if (korisnickoIme.equals(k.getKorisnickoIme()) && sifra.equals(k.getLozinka())) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzor glavni = new GlavniProzor(k);
							glavni.setVisible(true);
							ulogovan = true;
						}
					}
					if(!ulogovan)
					{
						JOptionPane.showMessageDialog(null, "Pogresno korisnicko ime ili lozinka", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

}
