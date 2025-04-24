package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;

	@BeforeEach
	public void setUp() {
		giocatore = new Giocatore();
		borsa = new Borsa();
		attrezzo1 = new Attrezzo("attrezzo1",2);
		attrezzo2 = new Attrezzo("attrezzo2",3);
		this.giocatore.setCfu(34);
		this.giocatore.setBorsa(borsa);
		this.giocatore.prendiAttrezzo(attrezzo1);
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(34, this.giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		assertEquals(borsa, this.giocatore.getBorsa());
	}
	
	@Test
	public void testPrendiAttrezzo() {
		assertTrue(this.giocatore.prendiAttrezzo(attrezzo2));
	}
	
	@Test
	public void testPosaAttrezzo() {
		assertEquals(attrezzo1, this.giocatore.posaAttrezzo("attrezzo1"));
		assertEquals(null, this.giocatore.posaAttrezzo("attrezzo2"));
	}

}
