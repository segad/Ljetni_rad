package sega.ljetnizadatak;

public class Artikl extends Kupac{
	String nazivArtikla;
	String dobavljacArtikla;
	String mjernaJedinicaArtikla;
	double stanjeArtikla;
	double cijenaArtikla;
	int sifraArtikla;
	
	
	
	public int getSifraArtikla() {
		return sifraArtikla;
	}
	public void setSifraArtikla(int sifraArtikla) {
		this.sifraArtikla = sifraArtikla;
	}
	public String getNazivArtikla() {
		return nazivArtikla;
	}
	public void setNazivArtikla(String nazivArtikla) {
		this.nazivArtikla = nazivArtikla;
	}

	public String getDobavljacArtikla() {
		return dobavljacArtikla;
	}
	public void setDobavljacArtikla(String dobavljacArtikla) {
		this.dobavljacArtikla = dobavljacArtikla;
	}
	
	public String getMjernaJedinicaArtikla() {
		return mjernaJedinicaArtikla;
	}
	public void setMjernaJedinicaArtikla(String mjernaJedinicaArtikla) {
		this.mjernaJedinicaArtikla = mjernaJedinicaArtikla;
	}
	public double getStanjeArtikla() {
		return stanjeArtikla;
	}
	public void setStanjeArtikla(double stanjeArtikla) {
		this.stanjeArtikla = stanjeArtikla;
	}
	public double getCijenaArtikla() {
		return cijenaArtikla;
	}
	public void setCijenaArtikla(double cijenaArtikla) {
		this.cijenaArtikla = cijenaArtikla;
	}

}
