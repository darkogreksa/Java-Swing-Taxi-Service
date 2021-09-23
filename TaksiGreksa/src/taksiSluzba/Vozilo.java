package taksiSluzba;

public class Vozilo {
	String model;
	String proizvodjac;
	int godinaProizvodnje;
	String registracija;
	int brojVozila;
	String vrstaVozila;
	
	Vozilo()
	{
		
	}

	public Vozilo(String model, String proizvodjac, int godinaProizvodnje, String registracija, int brojVozila,
			String vrstaVozila) {
		super();
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.registracija = registracija;
		this.brojVozila = brojVozila;
		this.vrstaVozila = vrstaVozila;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public int getBrojVozila() {
		return brojVozila;
	}

	public void setBrojVozila(int brojVozila) {
		this.brojVozila = brojVozila;
	}

	public String getVrstaVozila() {
		return vrstaVozila;
	}

	public void setVrstaVozila(String vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	@Override
	public String toString() {
		return "Vozilo [model=" + model + ", proizvodjac=" + proizvodjac + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", registracija=" + registracija + ", brojVozila=" + brojVozila + ", vrstaVozila=" + vrstaVozila
				+ "]";
	}
	

}
