package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Borsa borsa;
	
	@Before
	public void setUp() {
		attrezzo1 = new Attrezzo("attrezzo1", 2);
		attrezzo2 = new Attrezzo("attrezzo2", 11);
		attrezzo3 = new Attrezzo("attrezzo3", 5);
		borsa = new Borsa();
		this.borsa.addAttrezzo(attrezzo3);
	}
	
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo1));
		assertFalse(this.borsa.addAttrezzo(attrezzo2));
	}
	
	
	@Test
	public void testRemoveAttrezzo() {		
		assertEquals(attrezzo3, this.borsa.removeAttrezzo("attrezzo3"));
	}
	
	@Test
	public void testGetPeso() {
		this.borsa.addAttrezzo(attrezzo1);
		assertEquals(7, this.borsa.getPeso());
	}

}
