package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	private Labirinto labirinto;
	private Stanza stanza;

	@BeforeEach
	public void setUp() throws Exception {
	  this.labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
				
		this.partita = new Partita(labirinto);
		this.stanza = new Stanza("stanza2");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", this.partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		this.partita.setStanzaCorrente(stanza);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("biblioteca", this.partita.getLabirinto().getStanzaIniziale().getNome());
	}
	
	@Test
	public void testIsFinita(){
		assertFalse(this.partita.isFinita());
	}
}
