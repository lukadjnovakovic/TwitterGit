package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	Twitter tw;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
		
	}

	@Test
	public void testVratiSvePoruke() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", "poruka3");
		LinkedList<TwitterPoruka> proba = tw.vratiSvePoruke();
		assertEquals("pera", proba.get(0).getKorisnik());
		assertEquals("poruka1", proba.get(0).getPoruka());
		assertEquals("zika", proba.get(1).getKorisnik());
		assertEquals("poruka2", proba.get(1).getPoruka());
		assertEquals("laza", proba.get(2).getKorisnik());
		assertEquals("poruka3", proba.get(2).getPoruka());
		
	}

	@Test
	public void testVratiSvePoruke2() {
		assertTrue(tw.vratiSvePoruke().isEmpty());
	}
	
	@Test
	public void testUnesi() {
		
		tw.unesi("Pera","Text poruke");
		assertEquals("Pera", tw.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Text poruke", tw.vratiSvePoruke().getLast().getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesi2() {
		
		tw.unesi("","");

	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesi3() {
		
		tw.unesi(null,null);

	}
	
	@Test
	public void testVratiPoruke() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", "333");
		tw.unesi("mika", "444");
		tw.unesi("duka", "555");
		tw.unesi("maja", "666");
		
		TwitterPoruka[] proba = tw.vratiPoruke(10,"poruka");
		
		assertEquals("poruka1", proba[0].getPoruka());
		assertEquals("poruka2", proba[1].getPoruka());
		assertEquals("pera", proba[0].getKorisnik());
		assertEquals("zika", proba[1].getKorisnik());
	
	}

	@Test
	public void testVratiPoruke2() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", "333");
		tw.unesi("mika", "444");
		tw.unesi("duka", "555");
		tw.unesi("maja", "666");
		
		TwitterPoruka[] proba = tw.vratiPoruke(-2,"poruka");
		
		assertEquals("poruka1", proba[0].getPoruka());
		assertEquals("poruka2", proba[1].getPoruka());
		assertEquals("pera", proba[0].getKorisnik());
		assertEquals("zika", proba[1].getKorisnik());
	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke3() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", "333");
		tw.unesi("mika", "444");
		tw.unesi("duka", "555");
		tw.unesi("maja", "666");
		
		TwitterPoruka[] proba = tw.vratiPoruke(-2,"");
		
		assertEquals("poruka1", proba[0].getPoruka());
		assertEquals("poruka2", proba[1].getPoruka());
		assertEquals("pera", proba[0].getKorisnik());
		assertEquals("zika", proba[1].getKorisnik());
	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke4() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", "333");
		tw.unesi("mika", "444");
		tw.unesi("duka", "555");
		tw.unesi("maja", "666");
		
		TwitterPoruka[] proba = tw.vratiPoruke(-2,null);
		
		assertEquals("poruka1", proba[0].getPoruka());
		assertEquals("poruka2", proba[1].getPoruka());
		assertEquals("pera", proba[0].getKorisnik());
		assertEquals("zika", proba[1].getKorisnik());
	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke5() {
		tw.unesi("pera", "poruka1");
		tw.unesi("zika", "poruka2");
		tw.unesi("laza", null);
		tw.unesi("mika", "444");
		tw.unesi("duka", "555");
		tw.unesi("maja", "666");
		
		TwitterPoruka[] proba = tw.vratiPoruke(-2,"poruka");
		
		assertEquals("poruka1", proba[0].getPoruka());
		assertEquals("poruka2", proba[1].getPoruka());
		assertEquals("pera", proba[0].getKorisnik());
		assertEquals("zika", proba[1].getKorisnik());
	
	}
}
