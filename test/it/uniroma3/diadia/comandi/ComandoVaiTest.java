package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;;

public class ComandoVaiTest {
	private Partita p;
	private ComandoVai cv;
	private IO io;

	@BeforeEach
	void setUp() throws Exception {
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		p = new Partita(labirinto);
		cv = new ComandoVai();
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
		cv.setIO(io);
	}

	@Test
	public void testGetNome() {
		assertEquals("vai", cv.getNome());
	}
	
	@Test
	public void testComandoVaiDirezioneInesistente() {
		cv.setParametro("sud");
		cv.esegui(p);
		
		assertEquals(p.getStanzaCorrente().getNome(), "N11");
	}
	
	@Test
	public void testComandoVaiDirezioneEsistente() {
		cv.setParametro("nord");
		cv.esegui(p);
		
		assertEquals("N10", p.getStanzaCorrente().getNome());
	}

}
