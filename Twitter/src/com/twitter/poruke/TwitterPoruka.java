package com.twitter.poruke;

/**
 * klasa TwitterPoruka,sadrzi podatke o korisniku i poruci
 * @author LukaNovakovic
 *
 */
public class TwitterPoruka {

	/**
	 * ime korisnika
	 */
	private String korisnik;
	/**
	 * tekst poruke
	 */
	private String poruka;

	/**
	 * metoda za citanje imena Korisnika
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * metoda za postavljanje imena korisnika
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * metoda za preuzimanje teksta poruka
	 * @return tekstPoruke
	 */
	public String getPoruka() {
		return this.poruka;
	}
	
	/**
	 * metoda za zapisivanje teksta nove poruke
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * metoda koja vraca ime korisnika i njegovu poruku
	 * @return korisnik+poruka
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}