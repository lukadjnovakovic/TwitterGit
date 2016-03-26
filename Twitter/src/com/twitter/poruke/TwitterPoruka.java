package com.twitter.poruke;

/**
 * Klasa TwitterPoruka opisuje poruku i njenog korisnika
 * @author LukaNovakovic
 *
 */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika
	 */
	private String korisnik;
	
	/**
	 * poruka koju je korisnik uneo
	 */
	private String poruka;
	
	/**
	 * Metoda koja vraca ime korisnika neke poruke
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * metoda koja postavlja ime nekog korisnika
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * metoda koja vraca sadrzaj poruke
	 * @return poruka
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * metoda koja postavlja tekst neke poruke
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * metoda koja vraca korisnika i njegovu poruku kao string
	 * @return korisnik + poruka
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
	
	
}