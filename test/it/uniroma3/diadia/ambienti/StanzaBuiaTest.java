package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia sb;
	private Attrezzo attrezzoLucente;
	
	@BeforeEach
	public void setUp() throws Exception {
		sb = new StanzaBuia("sb", "attrezzoLucente");
		attrezzoLucente = new Attrezzo("attrezzoLucente",3);
	}

	@Test
	public void testAttrezzoLucenteNonPresente() {
	
		assertEquals(sb.getDescrizione(),"qui c'è un buio pesto");
	}
	
	@Test
	public void testAttrezzoLucentePresente() {
		sb.addAttrezzo(attrezzoLucente);
		assertEquals(sb.getDescrizione(),sb.toString());
	}
	

}
