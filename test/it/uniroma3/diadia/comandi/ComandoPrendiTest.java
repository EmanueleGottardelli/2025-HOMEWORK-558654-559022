package it.uniroma3.diadia.comandi;

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

public class ComandoPrendiTest {
	private Attrezzo a1; //attrezzo normale
	private Attrezzo a2; //attrezzo pesante
	private IO io;
	private Partita p;
	private ComandoPrendi cp;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		p = new Partita(labirinto);
		a1 = new Attrezzo("a1",2);
		a2 = new Attrezzo("a2", 100);
		cp = new ComandoPrendi();
		Scanner scanner = new Scanner(System.in);
		io = new IOConsole(scanner);
		cp.setIO(io);
	}
	
	@Test
	public void testGetNome() {
		assertEquals("prendi", cp.getNome());
	}
	
	@Test
	public void testPrendeAttrezzo() {
		assertTrue(p.getGiocatore().prendiAttrezzo(a1));	
	}
	
	@Test
	public void testAttrezzoPesante() {
		assertFalse(p.getGiocatore().prendiAttrezzo(a2));
	}

}
