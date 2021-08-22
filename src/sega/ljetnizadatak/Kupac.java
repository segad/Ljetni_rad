package sega.ljetnizadatak;

public class Kupac extends Osoba{
	int kupacID;
	int maxID;
	
	

	public int getMax() {
		return maxID;
	}

	public void setMax(int max) {
		this.maxID = max;
	}

	public int getKupacID() {
		return kupacID;
	}

	public void setKupacID(int kupacID) {
		this.kupacID = kupacID;
	}

}
