package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi fc;
	private ComandoVai cv;
	private ComandoFine cf;
	private ComandoNonValido cnv;
	private IO io;
	
	@BeforeEach
	public void setUp() throws Exception {
		io = new IOConsole();
		fc = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	public void testComandoNonValido() {
		cnv = new ComandoNonValido();
		assertEquals(cnv.getNome(), fc.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		cv = new ComandoVai();
		cv.setParametro("nord");
		Comando c = fc.costruisciComando("vai nord");
		assertEquals(cv.getNome(), c.getNome());
		assertEquals(cv.getParametro(), c.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		cf = new ComandoFine();
		assertEquals(cf.getNome(), fc.costruisciComando("fine").getNome());
	}

}
