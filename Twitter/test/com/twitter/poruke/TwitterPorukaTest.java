/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author LukaNovakovic
 *
 */

public class TwitterPorukaTest {
	
	private TwitterPoruka tp;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	 tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Pera");
		
		assertEquals( "Pera", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnik2() {
		tp.setKorisnik("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnik3() {
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		String novaPoruka = "bla bla";
		tp.setPoruka(novaPoruka);
		assertEquals(novaPoruka, tp.getPoruka());
	}

	@Test
	public void testSetPoruka2() {
		
		tp.setPoruka("");
		assertEquals("", tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("korisnik");
		tp.setPoruka("nova poruka");
		assertEquals("KORISNIK:korisnik PORUKA:nova poruka", tp.toString());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testToString2() {
		tp.setKorisnik("");
		tp.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testToString3() {
		tp.setKorisnik(null);
		tp.setPoruka(null);
	}
}