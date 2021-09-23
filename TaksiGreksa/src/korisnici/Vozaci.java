package korisnici;

//import java.util.ArrayList;

public class Vozaci extends Korisnik {
	
	private double plata;
	private String brojClanskeKarte;
	private String vozilo;

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public String getVozilo() {
		return vozilo;
	}

	public void setVozilo(String vozilo) {
		this.vozilo = vozilo;
	}

	public Vozaci(String ime, String prezime, String jmbg, String adresa, String pol, String telefon,
			String korisnickoIme, String lozinka, double plata, String brojClanskeKarte, String vozilo) {
		super(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka);
		this.plata = plata;
		this.brojClanskeKarte = brojClanskeKarte;
		this.vozilo = vozilo;
	}
	
	

}
