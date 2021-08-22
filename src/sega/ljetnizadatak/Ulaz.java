package sega.ljetnizadatak;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Ulaz {

	public static Scanner sc; // po defaultu predlaže korištenje naziva sc
	
	
	//////////////////////////////////////
	/////////// UNOS INTEGERA ////////////
	//////////////////////////////////////
	
	public static int ucitajCijeliBroj(String poruka, String greska, int min, int max) {
		
		int brojKojiJeUnioKorisnik = 0;
		while(true) {
			System.out.println(poruka);
			try {
			brojKojiJeUnioKorisnik = Integer.parseInt(sc.nextLine());
			while(brojKojiJeUnioKorisnik<min || brojKojiJeUnioKorisnik>max) {
				System.out.println("Unjeli ste broj "+ brojKojiJeUnioKorisnik + ". Ponuđeni brojevi su od " + min + " do " + max );
				System.out.println("Molim ponovno odaberite jednu od gore ponuđenih opcija");
				brojKojiJeUnioKorisnik = Integer.parseInt(sc.nextLine());
			}
				
				
			}catch (Exception e) {
				System.out.println(greska);
			}
			return brojKojiJeUnioKorisnik;
			
			
		}
	
	}
	
	
	//////////////////////////////////////
	/////////// UNOS STRINGA ////////////
	//////////////////////////////////////
	public static String ucitajString(String poruka, String greska) {
		String s="";
		while(true) {
			System.out.print(poruka);
			s = sc.nextLine();
			while(s.trim().equals("")){
				System.out.println(greska);
				s = sc.nextLine();
			}
			break;
		}
		
		return s;
	}
	
	
	//////////////////////////////////////
	//////////// UNOS DOUBLA /////////////
	//////////////////////////////////////
	
	public static double ucitajDouble(String poruka, String greska, double min, double max) {
		double brojKojiJeUnioKorisnik = 0;
		while(true) {
			System.out.println(poruka);
			try {
				brojKojiJeUnioKorisnik = Double.parseDouble(sc.nextLine());
				while(brojKojiJeUnioKorisnik<min || brojKojiJeUnioKorisnik>max) {
					System.out.println("Unjeli ste broj "+ brojKojiJeUnioKorisnik + ". Možete unjeti brojeve od " + min + " do " + max );
					System.out.println("Molim ponovno unesite broj");
					brojKojiJeUnioKorisnik = Double.parseDouble(sc.nextLine());
				}
			}catch (Exception e) {
				System.out.println(greska);
				brojKojiJeUnioKorisnik = Double.parseDouble(sc.nextLine());
				
				
			}
			return brojKojiJeUnioKorisnik;
		}
		
		
	}

//	do {
//	    try {
//	        Blob b = new Blob(id);
//	        break;
//	    }
//	    catch (Exception e) {
//	      System.out.println(e);
//	    }
//	    System.out.println("Enter a different ID: ");
//	    id = scan.nextInt();
//	} while(true);
	
	
	//////////////////////////////////////
	/////// UNOS MJERNE JEDINICE /////////
	//////////////////////////////////////
	public static String ucitajStringMjernaJedinica(String poruka, String greska) {
		String s = "";
		while (true) {
			System.out.print(poruka);
			s = sc.nextLine();
			while (s.trim().equals("")) {
				System.out.println(greska);
				s = sc.nextLine();
			}
			
			while(true) {
			if((s.trim().equals("kom"))||(s.trim().equals("m"))||(s.trim().equals("kg"))||(s.trim().equals("l"))) {
				break;
			} else {
				
				System.out.println(greska);
				s = sc.nextLine();
			}
			
			}
			
			break;
			
		}

		return s;
	}
	
	//////////////////////////////////////
	/////// UNOS BOOLEANA /////////
	//////////////////////////////////////
	
	public static boolean ucitajBoolean(String poruka, String greska) {
		String s;
		while(true) {
			System.out.print(poruka);
			s=sc.nextLine();
			if(s.trim().toLowerCase().equals("da")) {
				return true;
			}
			if(s.trim().toLowerCase().equals("ne")) {
				return false;
				
			}
			System.out.println(greska + " (unos da/ne)");
		}
	}
	
	//////////////////////////////////////
	/////// UNOS ELEMENTA KOJEG PROVJERAVA ARRAY /////////
	//////////////////////////////////////
	
	public static int ucitajElementIzNiza (String poruka) {
		System.out.println(poruka);
		int s;
		s= Integer.parseInt(sc.nextLine());
		return s;
	}


}

