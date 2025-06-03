package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class AbstractComandoTest {
	private ComandoFake cf;
	private Partita p;
	private Labirinto l;

	@BeforeEach
	public void setUp() throws Exception {
		l = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		p = new Partita(l);
		cf = new ComandoFake();
	}

	@Test
	public void testGetNome() {
		assertEquals("fake", this.cf.getNome());
	}
	
	@Test
	public void testEseguiFake() {
		cf.esegui(p);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testGetIO() {
		Scanner scanner = new Scanner(System.in);
		cf.setIO(new IOConsole(scanner));
		assertNotNull(cf.getIO());
	}
	
	@Test
	public void testParametro() {
		cf.setParametro("parametro");
		assertNotNull(cf.getParametro());
		assertEquals("parametro", cf.getParametro());
	}

}
