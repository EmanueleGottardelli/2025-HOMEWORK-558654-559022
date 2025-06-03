package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi fc;
	private Comando cv;
	private Comando cf;
	private Comando cnv;
	private IO io;
	
	@BeforeEach
	public void setUp() throws Exception {
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
		fc = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	public void testComandoNonValido() throws Exception {
		cnv = new ComandoNonValido();
		assertEquals(cnv.getNome(), fc.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() throws Exception {
		cv = new ComandoVai();
		cv.setParametro("nord");
		Comando c = fc.costruisciComando("vai nord");
		assertEquals(cv.getNome(), c.getNome());
		assertEquals(cv.getParametro(), c.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() throws Exception {
		cf = new ComandoFine();
		assertEquals(cf.getNome(), fc.costruisciComando("fine").getNome());
	}

}
