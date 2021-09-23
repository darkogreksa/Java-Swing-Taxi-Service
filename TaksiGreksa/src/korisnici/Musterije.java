package korisnici;

public class Musterije extends Korisnik {
	
	private String mobilnaAplikacija;
	
	public String getMobilnaAplikacija() {
		return mobilnaAplikacija;
	}

	public void setMobilnaAplikacija(String mobilnaAplikacija) {
		this.mobilnaAplikacija = mobilnaAplikacija;
	}

	public Musterije(String ime, String prezime, String jmbg, String adresa, String pol, String telefon,
			String korisnickoIme, String lozinka, String mobilnaAplikacija) {
		super(ime, prezime, jmbg, adresa, pol, telefon, korisnickoIme, lozinka);
		this.mobilnaAplikacija = mobilnaAplikacija;
	}

	@Override
	public String toString() {
		return "Musterije [mobilnaAplikacija=" + mobilnaAplikacija + "]";
	}



}
