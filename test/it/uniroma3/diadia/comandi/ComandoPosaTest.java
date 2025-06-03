package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	private Comando cp;
	private Partita p;
	private Attrezzo a;
	private IO io;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		p = new Partita(labirinto);
		cp = new ComandoPosa();
		a = new Attrezzo("a",2);
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
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
		assertTrue(p.getStanzaCorrente().getNumeroAttrezzi() == 10);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("a"));
	}

}
