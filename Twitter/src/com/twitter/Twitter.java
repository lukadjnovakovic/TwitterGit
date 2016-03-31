package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * klasa Twitter koja sadrzi listu TwitterPoruka metode za unos i pretragu poruka
 * @author LukaNovakovic
 *
 */
public class Twitter {
	/**
	 * lista TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke =	new LinkedList<TwitterPoruka>();
	
	/**
	 * metoda koja vraca sve poruka
	 * @return
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * unos nove poruke sa tekstom i korisnikom
	 * @param ime korisnika koji je uneo poruku
	 * @param poruka
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * metoda za pretragu poruka sa odredjenim tagom
	 * @param maxBroj - maksimalni broj poruka koji ce se vratiti kao rezultat
	 * @param tag koji sadrze sve poruke koje se vracaju kao rezultat
	 * @return niz poruka sa odredjenim tagom
	 * @throws java.lang.RuntimeException
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
		return rezultat;
	}
} 