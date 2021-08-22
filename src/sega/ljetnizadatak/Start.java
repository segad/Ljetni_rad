package sega.ljetnizadatak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;




public class Start {
	
	private List<Kupac> kupci;
	private List<Artikl> artikli;
	private List<Narudzba> narudzbe;

	
	
	public Start() {
		kupci = new ArrayList<Kupac>();
		artikli = new ArrayList<Artikl>();
		narudzbe = new ArrayList<Narudzba>();
		Ulaz.sc = new Scanner(System.in);
		glavniIzbornik();
		
		
	}
	
	
	 //////////////////////////////////////
	 //// / GLAVNI IZBORNIK - POČETAK//////
	 //////////////////////////////////////
	private void glavniIzbornik() {
		
		System.out.println("***Dobrodošli***");
		System.out.println("Alat za kreiranje narudžbi i izradu računa");
		System.out.println("Molim odaberite jednu od ponuđenih akcija");
		System.out.println("1. Kupci");
		System.out.println("2. Artikli");
		System.out.println("3. Narudžbe");
		System.out.println("4. Pregled GitHuba");
		System.out.println("5. Izlaz iz programa");
		odabirAkcije();
		
	}

	private void odabirAkcije() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 5)) {
		case 1:
			kupciIzbornik();
			break;
		case 2:
			artikliIzbornik();
			break;
		case 3:
			narudzbeIzbornik();
			break;
		case 4:
			gitHubIzbornik();
			break;
		case 5:
			System.out.println("Izašli ste iz programa.\nDoviđenja!");
			
		}		
	}



	//////////////////////////////////////
	 /////// GLAVNI IZBORNIK - KRAJ////////
	 //////////////////////////////////////
	
	
	
	 //////////////////////////////////////
	 ///////// KUPCI --- POČETAK///////////
	 //////////////////////////////////////
	
	private void kupciIzbornik() {
		System.out.println("\n***KUPCI***");
		System.out.println("1. Pregled postojećih kupaca");
		System.out.println("2. Unos novog kupca");
		System.out.println("3. Izmjena podataka kupca");
		System.out.println("4. Brisanje kupca");
		System.out.println("5. Povratak u glavni izbornik");
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 5)) {
		case 1:
			kupciPregled();
			break;
		case 2:
			kupciUnos();
			break;
		case 3:
			kupciIzmjena();
			break;
		case 4:
			kupciBrisanje();
			break;
		case 5:
			glavniIzbornik();
			return;		
		}	
		
	}


	private void kupciPregled() {
		kupacStavke("Pregled unešenih kupaca");
		kupciIzbornik();
		
	}


	private void kupacStavke(String naslov) {
		System.out.println(naslov);
		if (kupci.isEmpty()) {
			System.out.println("Nema unesenih kupaca");
			kupciIzbornik();
		} else {
			Kupac k;
			for (int i = 0; i < kupci.size(); i++) {
				k = kupci.get(i);
				System.out.println((i + 1) + ". " + k.getIme() + " " + k.getPrezime() + " KupacID: " + k.getKupacID());
			}
		
		}
		
	}


	private void kupciUnos() {
		Kupac k = new Kupac();
		k = kupciPostavljanjeVrijednosti(k);
		kupci.add(k);
		kupciIzbornik();
	}


	private Kupac kupciPostavljanjeVrijednosti(Kupac k) {
		k.setIme(Ulaz.ucitajString("Unesite ime kupca", "Niste unjeli ime"));
		k.setPrezime(Ulaz.ucitajString("Unesite prezime kupca", "Niste unjeli prezime"));
		k.setAdresa(Ulaz.ucitajString("Unesite adresu kupca", "Niste unjeli adresu"));
		k.setTelefon(Ulaz.ucitajString("Unesite telefonski broj", "Niste unjeli telefonski broj"));
		k.setKupacID(jedinstvenIDkupca()); //Automaski generira ID kupca kako bi svaki novi kupac imao unikatan ID.
		return k;
	}
	
	private int jedinstvenIDkupca() {
		int maxBroj;
		Kupac k;
		if(kupci.size() == 0) {
			maxBroj=1;
		}else {
			k = kupci.get(kupci.size()-1);
			maxBroj = k.getKupacID() + 1;
		}
		return maxBroj;
		
	}


	private void kupciIzmjena() {
		kupacStavke("Trenutni popis kupaca");
		int kupacBrojzaIzmjenu = Ulaz.ucitajCijeliBroj("Odaberite redni broj korisnika kojeg želite izmjeniti", "Nepostojeći korisnik", 0, kupci.size());
		Kupac k;
		k = kupci.get(kupacBrojzaIzmjenu-1);
		System.out.println((kupacBrojzaIzmjenu) + ". " + k.getIme() + " " + k.getPrezime() + " KupacID: " + k.getKupacID());
		System.out.println("Odaberite koji podatak želite izmjeniti");
		System.out.println("1. Ime kupca");
		System.out.println("2. Prezime kupca");
		System.out.println("3. Adresu kupca");
		System.out.println("4. Telefonski broj kupca");
		
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 4)) {
		case 1:
			k.setIme(Ulaz.ucitajString("Unesite novo ime kupca", "Niste unjeli ime"));
			break;
		case 2:
			k.setPrezime(Ulaz.ucitajString("Unesite novo prezime kupca", "Niste unjeli prezime"));
			break;
		case 3:
			k.setAdresa(Ulaz.ucitajString("Unesite novu adresu kupca", "Niste unjeli adresu"));
			break;
		case 4:
			k.setTelefon(Ulaz.ucitajString("Unesite telefonski broj", "Niste unjeli telefonski broj"));
			break;
		
		}	
		System.out.println("Pregled izmjenjenog kupca");
		System.out.println((kupacBrojzaIzmjenu) + ". " + k.getIme() + " " + k.getPrezime() + " KupacID: " + k.getKupacID());
		kupciIzbornik();
		
	}


	private void kupciBrisanje() {
		kupacStavke("Trenutni popis kupaca");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za brisanje: ", "Niste unijeli cijeli broj", 1,
				kupci.size());
		kupci.remove(redniBroj - 1);
		kupciIzbornik();	
	}
	 //////////////////////////////////////
	 /////////// KUPCI --- KRAJ////////////
	 //////////////////////////////////////

	
	
	
	 //////////////////////////////////////
	 ///////// ARTIKLI --- POČETAK/////////
	 //////////////////////////////////////

	private void artikliIzbornik() {
		System.out.println("\n***ARTIKLI***");
		System.out.println("1. Pregled postojećih artikla");
		System.out.println("2. Unos novog artikla");
		System.out.println("3. Izmjena podataka artikla");
		System.out.println("4. Brisanje artikla");
		System.out.println("5. Povratak u glavni izbornik");
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 5)) {
		case 1:
			artikliPregled();
			break;
		case 2:
			artikliUnos();
			break;
		case 3:
			artikliIzmjena();
			break;
		case 4:
			artikliBrisanje();
			break;
		case 5:
			glavniIzbornik();
			return;		
		}	
	}
	
	
	
	 private void artikliPregled() {
		artikliStavke("Pregled unešenih artikala");
		artikliIzbornik();
		
	}


	private void artikliStavke(String naziv) {
		System.out.println(naziv);
		if(artikli.isEmpty()) {
			System.out.println("Trenutno nemate unešenih artikala");
			artikliIzbornik();
		}else {
			Artikl a;
			for(int i=0; i<artikli.size(); i++) {
				a = artikli.get(i);
				System.out.println((i+1) + ". " + a.getNazivArtikla() + " Dobavljač: " + a.getDobavljacArtikla() + " Stanje artikla: " + a.getStanjeArtikla() 
				+ " " +a.getMjernaJedinicaArtikla()+ " Šifra artikla: " + a.getSifraArtikla() + ", Cijena artikla: " + a.getCijenaArtikla() + " kn");
			}	
		}	
	}


	private void artikliUnos() {
		Artikl a = new Artikl();
		a = artikliPostavljanjeVrijednosti(a);
		artikli.add(a);
		artikliIzbornik();
		
	}


	private Artikl artikliPostavljanjeVrijednosti(Artikl a) {
		a.setNazivArtikla(Ulaz.ucitajString("Unesite naziv artikla", "Prazan unos"));
		a.setSifraArtikla(jedinstvenaŠifraArtikla());
		a.setDobavljacArtikla(Ulaz.ucitajString("Unesite naziv dobavljača", "Prazan unos"));
		a.setMjernaJedinicaArtikla(Ulaz.ucitajStringMjernaJedinica("Unesite mjernu jedinicu artikla. Dozvoljeni formati za unos su: \nkom,\tm, \nl, \tkg.",
				"Neispravan unos. Dozvoljeni formati su: \nkom,\tm, \nl, \tkg."));
		a.setStanjeArtikla(Ulaz.ucitajDouble("Unesite količinu artikla", "Neispravan unos", 0.1, 100000));
		a.setCijenaArtikla(Ulaz.ucitajDouble("Unesite jediničnu cijenu artikla u HRK", "Neispravan unos", 0.1, 1000000));
		System.out.println("Uspješno ste unjeli artikl. Povratak u prethodni izbornik");
		return a;
	
	}
	



	private int jedinstvenaŠifraArtikla() {
		int maxBroj;
		Artikl a;
		if(artikli.size() == 0) {
			maxBroj=1;
		}else {
			a = artikli.get(artikli.size()-1);
			maxBroj = a.getSifraArtikla() + 1;
		}
		return maxBroj;
		
	}


	private void artikliIzmjena() {
		artikliStavke("Trenutni popis artikala");
		int artiklBrojzaIzmjenu = Ulaz.ucitajCijeliBroj("Odaberite redni broj korisnika kojeg želite izmjeniti", "Nepostojeći korisnik", 1, artikli.size());
		Artikl a;
		a = artikli.get(artiklBrojzaIzmjenu-1);
		System.out.println((artiklBrojzaIzmjenu) + ". " + a.getNazivArtikla() + " Dobavljač: " + a.getDobavljacArtikla() + " Stanje artikla: " + a.getStanjeArtikla() 
		+ " " +a.getMjernaJedinicaArtikla()+ " Šifra artikla: " + a.getSifraArtikla() + ", Cijena artikla: " + a.getCijenaArtikla() + " kn");
		System.out.println("Odaberite koji podatak želite izmjeniti");
		System.out.println("1. Naziv artikla");
		System.out.println("2. Dobavljač");
		System.out.println("3. Stanje artikla");
		System.out.println("4. Mjerna jedinica");
		System.out.println("5. Cijena artikla");
		
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 5)) {
		case 1:
			a.setNazivArtikla(Ulaz.ucitajString("Unesite novi naziv artikla", "Niste unjeli naziv"));
			break;
		case 2:
			a.setDobavljacArtikla(Ulaz.ucitajString("Unesite drugog dobavljača", "Niste unjeli naziv"));
			break;
		case 3:
			a.setStanjeArtikla(Ulaz.ucitajDouble("Unesite novu količinu artikla", "Neispravan unos", 0.1, 100000));
			break;
		case 4:
			a.setMjernaJedinicaArtikla(Ulaz.ucitajStringMjernaJedinica("Unesite mjernu jedinicu artikla. Dozvoljeni formati za unos su: \nkom,\tm, \nl, \tkg.",
					"Neispravan unos. Dozvoljeni formati su: \nkom,\tm, \nl, \tkg."));
			break;
		case 5:
			a.setCijenaArtikla(Ulaz.ucitajDouble("Unesite jediničnu cijenu artikla u HRK", "Neispravan unos", 0.1, 1000000));
			break;
		
		}	
		System.out.println("Pregled izmjenjenog kupca");
		System.out.println((artiklBrojzaIzmjenu) +  ". " + a.getNazivArtikla() + ", Dobavljač: " + a.getDobavljacArtikla() + ", Stanje artikla: " + a.getStanjeArtikla() 
		+ " " +a.getMjernaJedinicaArtikla()+ ", Šifra artikla: " + a.getSifraArtikla()+ ", Cijena artikla: " + a.getCijenaArtikla() + " kn");
		artikliIzbornik();
	}


	private void artikliBrisanje() {
		artikliStavke("Trenutni popis artikala");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za brisanje: ", "Niste unijeli cijeli broj", 1,
				artikli.size());
		artikli.remove(redniBroj - 1);
		artikliIzbornik();	
		
	}


	//////////////////////////////////////
	 /////////// ARTIKLI --- KRAJ//////////
	 //////////////////////////////////////
	

	
	
	
	 //////////////////////////////////////
	 ///////// NARUDŽBE --- POČETAK/////////
	 //////////////////////////////////////
	private void narudzbeIzbornik() {
		System.out.println("***NARUDŽBE***");
		System.out.println("1. Pregled narudžbi");
		System.out.println("2. Nova narudžba");
		System.out.println("3. Brisanje narudžbe");
		System.out.println("4. Povratak u glavni izbornik");
		switch(Ulaz.ucitajCijeliBroj("Odaberi jednu od ponuđenih opcija", "Nespravan unos", 1, 4)) {
		case 1:
			narudzbePregled();
			break;
		case 2:
			narudzbeUnos();
			break;

		case 3:
			narudzbeBrisanje();
			break;
		case 4:
			glavniIzbornik();
			return;		
		}	
		
	}

	
	
//***** NARUDŽBE PREGLED POČETAK*****	
	private void narudzbePregled() {
		narudzbeStavke("Pregled unešenih narudžbi");
		boolean uvjet = Ulaz.ucitajBoolean("Upisite 'da' za detalje pojedine narudžbe, 'ne' za povratak u glavni izbornik narudžbi", "Neispravan unos");
		if(uvjet == true) {
			narudzbeStavkeDetalji("Odaberite koju narudžbu želite pregledati");
		}else if(uvjet == false) {
			System.out.println("Narudzba završena");
			narudzbeIzbornik();
		}
		narudzbeIzbornik();
		
	}


	private void narudzbeStavke(String naziv) {
		System.out.println(naziv);
		if(narudzbe.isEmpty()) {
			System.out.println("Trenutno nemate kreiranu ni jednu narudžbu");
			narudzbeIzbornik();
		}else {
			Narudzba n;
			Kupac k;
			n = narudzbe.get(0);
			int brojNarudzbe = n.getNarudzbaID();
			boolean uvjet = false;
			for(int i=0; i<narudzbe.size(); i++) {
				n = narudzbe.get(i);
				
				
				if(brojNarudzbe != n.getNarudzbaID() && (uvjet == true)) {
					
					brojNarudzbe = n.getNarudzbaID();
					uvjet = false;
					
				}
				
				// Ovo će se izvesti prvo
				if((brojNarudzbe == n.getNarudzbaID()) && (uvjet == false)) {
					
					System.out.print("Narudžba broj: " + n.getNarudzbaID() );
					int kupacID = n.getKupacID();
					for(int j=0; j<kupci.size();j++) {
						k=kupci.get(j);
						if(kupacID == k.getKupacID()) {
							System.out.println(" Kupac: "+ k.getIme() + " " + k.getPrezime());
							uvjet = true;
						}
					}
			
				}
				
			}	
		}	
			
	}
	
	private void narudzbeStavkeDetalji(String poruka) {
		System.out.println(poruka);
		Narudzba n;
		Kupac k;
		Artikl a;
		

		int narudzbaID = kreiranjeNizasaBrojevimaNarudzbi();
		
		//sada slijedi ispis svih stavki iz te narudžbe
	

		for(int i=0; i<narudzbe.size();i++) {
			double ukupnaCijena = 0;
			n = narudzbe.get(i);
			if(n.getNarudzbaID() == narudzbaID) {
				
				//Ispisujem kupca samo jednom
					
					for(int j=0; j<kupci.size();j++) {
						System.out.println("-----------------------------------------");
						System.out.println("Narudžba broj " + n.getNarudzbaID() );
						k = kupci.get(j);
						if(k.getKupacID()==n.getKupacID()) {
							System.out.println("Podatci o kupcu");
							System.out.println("ID kupca: " + k.getKupacID() + ", Ime: " + k.getIme() + " Prezime: " + k.getPrezime() + " Adresa:" + k.getAdresa());
							System.out.println("-----------------------------------------");
							break;
						}
						
					}
				
								
				//Prolazim kroz niz narudžbe, isčitavam šifru artikla te pretražujem u nizu artikli proizvod sa tom šifrom i od tamo izvlačim podatke
				for(int j = 0; j<narudzbe.size(); j++) {

					n = narudzbe.get(j);
					if(n.getNarudzbaID() == narudzbaID) {
						for(int c = 0; c<artikli.size(); c++) {  // Ovdje koristim slovo c jer sam i k te j ispucao, a k ne smijem koristiti zbog kupci = k
							a = artikli.get(c);
							if(n.getSifraArtikla() == a.getSifraArtikla()) {
								System.out.println((j+1) + ". " + a.getNazivArtikla() + " Količina: " + n.getStanjeArtikla() + " Jed. cijena: " + n.getCijenaArtikla() + " kn");
							}
							ukupnaCijena +=n.getUkupnaCijena();
						}
					}
				}
				//Prekini petlju kada si ispisao što si trebao
				System.out.println("-----------------------------------------");
				System.out.println("Ukupno za platiti: \t" + ukupnaCijena + " kn");
				System.out.println("-----------------------------------------");
				
				break;
				
			}
			
		}
		
		
	}
	
	private int kreiranjeNizasaBrojevimaNarudzbi() {
		Narudzba n;
		
		//Prvo cu kreirati niz
		n = narudzbe.get(0);
		int prviIDNarudzbi = n.getNarudzbaID();
		int ukupnoNarudzbi = 0;
		if(prviIDNarudzbi>=1) {
			ukupnoNarudzbi = 1;
		}
		
		for(int i = 0; i<narudzbe.size();i++) {
			n = narudzbe.get(i);
			if(prviIDNarudzbi != n.getNarudzbaID()) {
				ukupnoNarudzbi +=1;
			}
		}
			
		
		//kreiram niz u kojeg ću strpati sve ID-ove narudžbi koje imam
		int [] nizIDaNarudzbi;		
		nizIDaNarudzbi = new int[ukupnoNarudzbi];
		//sad ga krećem puniti
		n = narudzbe.get(0);
		prviIDNarudzbi = n.getNarudzbaID();
		nizIDaNarudzbi [0] = prviIDNarudzbi;
		for(int i= 1; i<ukupnoNarudzbi; i++) {
			n = narudzbe.get(i);
			if(prviIDNarudzbi != n.getNarudzbaID()) {
				nizIDaNarudzbi [i] = n.getNarudzbaID();
			}
			
		}
		int narudbzaID;
		while(true) {
			boolean izlazIzWhilea = false;
			narudbzaID = Ulaz.ucitajElementIzNiza("Unesi ID narudžbe");
			for(int i=0; i<nizIDaNarudzbi.length; i++) {
				if(nizIDaNarudzbi[i] == narudbzaID) {
					izlazIzWhilea = true;
				}
			}
			if(izlazIzWhilea) {
				break;
			} else {
				System.out.println("Neispravan unos");
			}
		}
		
		return narudbzaID;
		
		
	}

//***** NARUDŽBE PREGLED KRAJ*****	
	
	
//***** NARUDŽBE UNOS POČETAK*****
	private void narudzbeUnos() {
		
		kupacStavke("Pregled kupaca");
		int kupacNarudzba = Ulaz.ucitajCijeliBroj("Odaberite redni broj kupca", "Nepostojeći korisnik", 0, kupci.size());
		System.out.println("Kupac odabran. Molim odaberite artikle za narudžbu.");
		odabirArtiklaZaNarudzbu(kupacNarudzba-1,jedinstvenaŠifraNarudbze());
		
		
	}
	public void odabirArtiklaZaNarudzbu (int redniBrojKupca, int narudzbaID) {
		artikliStavke("Pregled unešenih artikala");
		
		Narudzba n = new Narudzba();
		Kupac k;
		k = kupci.get(redniBrojKupca);
		int rbrkupca = redniBrojKupca;
		int kupacID = k.getKupacID();
		n = dodavanjeArtikalaUNarudzbu(n);
		n.setKupacID(kupacID);
		n.setNarudzbaID(narudzbaID);
		narudzbe.add(n);
		System.out.println("Želite li dodati još artikla u narudžbu?");
		boolean uvjet = Ulaz.ucitajBoolean("Upisite 'da' za još artikala, 'ne' za završetak", "Neispravan unos");
		if(uvjet == true) {
			
			odabirArtiklaZaNarudzbu(rbrkupca, n.getNarudzbaID());
			
		}else if(uvjet == false) {
			System.out.println("Narudzba završena");
			
			//Umanjenje stanja artikala na skladištu kada se narudžba izvrši
			
			//Prvo čitanje koji su to artikli u narudžbi
			Artikl a;
			double novaVrijednost = 0;
			for(int i = 0; i<narudzbe.size();i++) {
				n = narudzbe.get(i);
				if(n.getNarudzbaID() == narudzbaID ) {
					for(int j= 0; j<artikli.size();j++) {
						a = artikli.get(j);
						if(a.getSifraArtikla()==n.getSifraArtikla()) {
							novaVrijednost =  a.getStanjeArtikla() - n.getStanjeArtikla();
							a.setStanjeArtikla(novaVrijednost);
							
						}
						
					}
					
				}
			}
			
			narudzbeIzbornik();
		}
		
		
	}


	private Narudzba dodavanjeArtikalaUNarudzbu(Narudzba n) {
		int redniBrojArtikla = Ulaz.ucitajCijeliBroj("Odaberite redni broj artikla", "Nepostojeći artikl", 0, artikli.size());
		Artikl a;
		a = artikli.get(redniBrojArtikla - 1);
		n.setSifraArtikla(a.getSifraArtikla());
		double kolicinaArtikla;
		kolicinaArtikla = Ulaz.ucitajDouble("Unesite količinu artikla", "Neispravan unos", 0.1, a.getStanjeArtikla());
		while(true) {
			if(kolicinaArtikla > a.getStanjeArtikla() ) {
				kolicinaArtikla = Ulaz.ucitajDouble("Unesite novu količinu artikla", "Neispravan unos", 0.1, a.getStanjeArtikla());
	
			}else {
				break;
			}
		}
		
		n.setStanjeArtikla(kolicinaArtikla);
		n.setUkupnaCijena(kolicinaArtikla*(a.getCijenaArtikla()));
		return n;
	}
	
	private int jedinstvenaŠifraNarudbze() {
		int maxBroj;
		Narudzba n;
		if(narudzbe.size() == 0) {
			maxBroj=1;
		}else {
			n = narudzbe.get(narudzbe.size()-1);
			maxBroj = n.getNarudzbaID() + 1;
		}
		return maxBroj;
		
	}

	//***** NARUDŽBE UNOS KRAJ*****
	
	

	//***** NARUDŽBE BRISANJE POČETAK*****

	private void narudzbeBrisanje() {
		narudzbeStavke("Upiši broj narudžbe koju želite obrisati");
		int narudzbaID = kreiranjeNizasaBrojevimaNarudzbi();
		boolean uvjet = Ulaz.ucitajBoolean("Jeste li sigurni da želite obrisati narudžbu (da/ne)", "Neispravan unos");
		Narudzba n;
		if(uvjet) {
			for(int i=0; i<narudzbe.size();i++) {
				n = narudzbe.get(i);
				if(n.getNarudzbaID() == narudzbaID) {
					narudzbe.remove(i);
					
				}
			}
			System.out.println("Nardužba broj " + narudzbaID + ". obrisana. Povratak u glavni izbornik narudžbi");
			narudzbeIzbornik();
			
		}else {
			narudzbeIzbornik();
		}
		
	}
	
	//***** NARUDŽBE BRISANJE KRAJ*****


	


	//////////////////////////////////////
	 /////////// NARUDŽBE --- KRAJ//////////
	 //////////////////////////////////////	
	


	 private void gitHubIzbornik() {

	        String url = "https://github.com/segad/Ljetni_rad/blob/main/README.md";

	        if(Desktop.isDesktopSupported()){
	            Desktop desktop = Desktop.getDesktop();
	            try {
	                desktop.browse(new URI(url));
	            } catch (IOException | URISyntaxException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }else{
	            Runtime runtime = Runtime.getRuntime();
	            try {
	                runtime.exec("xdg-open " + url);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        glavniIzbornik();
	}


	public static void main(String[] args) {
		
		new Start();
	}

}
