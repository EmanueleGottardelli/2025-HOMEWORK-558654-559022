package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata sb;
	private Attrezzo attrezzoSbloccante;
	private Stanza s;
	
	@BeforeEach
	public void setUp() throws Exception {
		attrezzoSbloccante = new Attrezzo("piede di porco",3);
		sb = new StanzaBloccata("sb","nord","piede di porco");
		s = new Stanza("s");
		sb.impostaStanzaAdiacente("nord", s);
	}

	@Test
	public void testDescrizioneStanzaBloccata() {
		sb.addAttrezzo(attrezzoSbloccante);
		assertEquals(sb.toString(),sb.getDescrizione());
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(sb,sb.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(attrezzoSbloccante);
		assertEquals(s,sb.getStanzaAdiacente("nord"));
	}

}
