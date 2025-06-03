package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	private StanzaMagica sm;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;

	@BeforeEach
	void setUp() throws Exception {
		sm = new StanzaMagica("sm", 2);
		a1 = new Attrezzo("a1", 1);
		a2 = new Attrezzo("a2",2);
		a3 = new Attrezzo("a3",3);
		sm.addAttrezzo(a1);
		sm.addAttrezzo(a2);
	}

	@Test
	public void testModificaAttrezzoPeso() {
		sm.addAttrezzo(a3);
		assertEquals(6, sm.getAttrezzo("3a").getPeso());
	}

	@Test
	public void testAttrezzoGiaPresente(){
		assertTrue(sm.hasAttrezzo("a2"));
		assertEquals("a2",sm.getAttrezzo("a2").getNome());
		assertEquals(2,sm.getAttrezzo("a2").getPeso());
	}
	
	@Test
	public void testStanzaSogliaModificata(){	
	
		StanzaMagica sm2 = new StanzaMagica("sm2",0);
		sm2.addAttrezzo(a1);
		assertTrue(sm2.addAttrezzo(a2));
		assertTrue(sm2.addAttrezzo(a3));
		
		assertEquals("1a", sm2.getAttrezzo("1a").getNome());
		assertEquals(4,sm2.getAttrezzo("2a").getPeso());
		assertEquals("3a",sm2.getAttrezzo("3a").getNome());
	}
				
	}
