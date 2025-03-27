package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	private Stanza stanza1;

	@Before
	public void setUp() {
		partita = new Partita();
		stanza1 = new Stanza("stanza1");
	}
	
	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(stanza1);
		assertFalse(this.partita.vinta());
		
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testIsFinita() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testSetFinita(){
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());	
	}
}
