package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

import org.junit.jupiter.api.BeforeEach;

public class LabirintoTest {
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("biblioteca", this.labirinto.getStanzaIniziale().getNome());
	}

}
