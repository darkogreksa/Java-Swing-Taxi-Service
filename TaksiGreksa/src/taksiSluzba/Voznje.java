package taksiSluzba;

public class Voznje {
	
	String imePrezimeMusterije;
	String datumPolaska;
	String adresaPolaska;
	String nacinPorudzbine;
	String vozac;
	String dispecer;
	String vrstaVozila;
	String napomena;
	
	public String getImePrezimeMusterije() {
		return imePrezimeMusterije;
	}
	public void setImePrezimeMusterije(String imePrezimeMusterije) {
		this.imePrezimeMusterije = imePrezimeMusterije;
	}
	public String getDatumPolaska() {
		return datumPolaska;
	}
	public void setDatumPolaska(String datumPolaska) {
		this.datumPolaska = datumPolaska;
	}
	public String getAdresaPolaska() {
		return adresaPolaska;
	}
	public void setAdresaPolaska(String adresaPolaska) {
		this.adresaPolaska = adresaPolaska;
	}
	public String getNacinPorudzbine() {
		return nacinPorudzbine;
	}
	public void setNacinPorudzbine(String nacinPorudzbine) {
		this.nacinPorudzbine = nacinPorudzbine;
	}
	public String getVozac() {
		return vozac;
	}
	public void setVozac(String vozac) {
		this.vozac = vozac;
	}
	public String getDispecer() {
		return dispecer;
	}
	public void setDispecer(String dispecer) {
		this.dispecer = dispecer;
	}
	public String getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(String vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	@Override
	public String toString() {
		return "Voznje [imePrezimeMusterije=" + imePrezimeMusterije + ", datumPolaska=" + datumPolaska
				+ ", adresaPolaska=" + adresaPolaska + ", nacinPorudzbine=" + nacinPorudzbine + ", vozac=" + vozac
				+ ", dispecer=" + dispecer + ", vrstaVozila=" + vrstaVozila + ", napomena=" + napomena + "]";
	}
	public Voznje(String imePrezimeMusterije, String datumPolaska, String adresaPolaska, String nacinPorudzbine,
			String vozac, String dispecer, String vrstaVozila, String napomena) {
		super();
		this.imePrezimeMusterije = imePrezimeMusterije;
		this.datumPolaska = datumPolaska;
		this.adresaPolaska = adresaPolaska;
		this.nacinPorudzbine = nacinPorudzbine;
		this.vozac = vozac;
		this.dispecer = dispecer;
		this.vrstaVozila = vrstaVozila;
		this.napomena = napomena;
	}
	
}
