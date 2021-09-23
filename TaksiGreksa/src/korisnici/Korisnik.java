package korisnici;

public abstract class Korisnik {

	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String adresa;
	protected String pol;
	protected String telefon;
	protected String korisnickoIme;
	protected String lozinka;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public Korisnik(String ime, String prezime, String jmbg, String adresa, String pol, String telefon,
			String korisnickoIme, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
		this.telefon = telefon;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}
	
	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol="
				+ pol + ", telefon=" + telefon + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
}
