package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	private ComandoPosa cp;
	private Partita p;
	private Attrezzo a;
	private IO io;

	@BeforeEach
	public void setUp() {
		p = new Partita();
		cp = new ComandoPosa();
		a = new Attrezzo("a",2);
		io = new IOConsole();
		cp.setIO(io);
	}
	
	@Test
	public void testGetNome() {
		assertEquals("posa", cp.getNome());
	}
	
	@Test
	public void testPosaAttrezzo() {
		p.getGiocatore().getBorsa().addAttrezzo(a);
		cp.setParametro("a");
		cp.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("a"));
	}
	
	@Test 
	public void testPosaAttrezzoNull() {
		cp.setParametro("a");
		cp.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("a"));
	}
	
	public void creatoreAttrezzi() {
		for(int i = 0; i<10; i++) {
			p.getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo"+i,1));
		}
	}
	
	@Test
	public void testStanzaPiena() {
		this.creatoreAttrezzi();
		p.getGiocatore().getBorsa().addAttrezzo(a);
		cp.setParametro("a");
		cp.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("a"));
	}

}
