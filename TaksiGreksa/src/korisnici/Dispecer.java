package korisnici;

public class Dispecer extends Korisnik {

	private double plata;
	private String telefonskaLinija;
	private String telefonskoOdeljenje;
	
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	public String getTelefonskaLinija() {
		return telefonskaLinija;
	}
	public void setTelefonskaLinija(String telefonskaLinija) {
		this.telefonskaLinija = telefonskaLinija;
	}
	public String getTelefonskoOdeljenje() {
		return telefonskoOdeljenje;
	}
	public void setTelefonskoOdeljenje(String telefonskoOdeljenje) {
		this.telefonskoOdeljenje = telefonskoOdeljenje;
	}
	public Dispecer(String ime, String prezime, String jmbg, String adresa, String pol, String telefon,
			String korisnickoIme, String lozinka, double plata, String telefonskaLinija,
			String telefonskoOdeljenje) {
		super(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka);
		this.plata = plata;
		this.telefonskaLinija = telefonskaLinija;
		this.telefonskoOdeljenje = telefonskoOdeljenje;
	}
	@Override
	public String toString() {
		return "Dispecer [plata=" + plata + ", telefonskaLinija=" + telefonskaLinija + ", telefonskoOdeljenje="
				+ telefonskoOdeljenje + "]";
	}	

}
