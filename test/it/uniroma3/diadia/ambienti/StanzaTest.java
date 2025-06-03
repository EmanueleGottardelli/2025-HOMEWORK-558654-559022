package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanza1;
	private Stanza stanza2;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	
	@BeforeEach
	public void setUp() {
		stanza1 = new Stanza("stanza1");
		stanza2 = new Stanza("stanza2");
		attrezzo1 = new Attrezzo("attrezzo1",1);
		attrezzo2 = new Attrezzo("attrezzo2",2);
		attrezzo3 = new Attrezzo("attrezzo3",3);
		
		this.stanza1.impostaStanzaAdiacente(Direzione.valueOf("nord"), stanza2);
		this.stanza2.impostaStanzaAdiacente(Direzione.valueOf("sud"), stanza1);
		
		this.stanza1.addAttrezzo(attrezzo3);
		
	}

	@Test
	public void testGetStanzaAdiacente() {		
		assertEquals(stanza1, this.stanza2.getStanzaAdiacente(Direzione.valueOf("sud")));
		assertEquals(stanza2, this.stanza1.getStanzaAdiacente(Direzione.valueOf("nord")));
	}
	
	@Test
	public void testAddAtterezzo() {
		assertTrue(this.stanza1.addAttrezzo(attrezzo1));
		assertTrue(this.stanza2.addAttrezzo(attrezzo2));
	}
	
	@Test
	public void testRemoveAttrezzo(){
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 2);
		
		assertTrue(this.stanza1.removeAttrezzo(attrezzo3));
		assertFalse(this.stanza1.removeAttrezzo(attrezzo4));
		assertFalse(this.stanza1.removeAttrezzo(attrezzo2));
		
	}
}
