package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePesoNome;

public class BorsaTest {
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Borsa borsa;
	
	@BeforeEach
	public void setUp() {
		attrezzo1 = new Attrezzo("attrezzo1", 2);
		attrezzo2 = new Attrezzo("attrezzo2", 20);
		attrezzo3 = new Attrezzo("attrezzo3", 5);
		borsa = new Borsa();
		this.borsa.addAttrezzo(attrezzo3);
	}
	
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo1));
		assertFalse(this.borsa.addAttrezzo(attrezzo2));
	}
	
	
	@Test
	public void testRemoveAttrezzo() {		
		assertEquals(attrezzo3, this.borsa.removeAttrezzo("attrezzo3"));
	}
	
	@Test
	public void testGetPeso() {
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 2);
		this.borsa.addAttrezzo(attrezzo4);
		this.borsa.addAttrezzo(attrezzo1);
		assertEquals(9, this.borsa.getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		this.borsa.addAttrezzo(attrezzo1);
		Attrezzo a4 = new Attrezzo("a4", 2);
		this.borsa.addAttrezzo(a4);
		assertEquals(a4,this.borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(attrezzo3, this.borsa.getContenutoOrdinatoPerPeso().get(2));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		this.borsa.addAttrezzo(attrezzo1);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo0", 0);
		assertTrue(this.borsa.addAttrezzo(attrezzo4));
		assertEquals(attrezzo4, this.borsa.getContenutoOrdinatoPerNome().first());
		assertEquals(attrezzo3, this.borsa.getContenutoOrdinatoPerNome().last());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		this.borsa.addAttrezzo(attrezzo1);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 2);
		assertTrue(this.borsa.addAttrezzo(attrezzo4));
		Set<Attrezzo> ex = new HashSet<>();
		ex.add(attrezzo1);
		ex.add(attrezzo4);
		Set<Attrezzo> ex2 = new HashSet<>();
		ex2.add(attrezzo3);
		assertEquals(ex.toString(), this.borsa.getContenutoRaggruppatoPerPeso().get(2).toString());
		assertEquals(ex2.toString(),this.borsa.getContenutoRaggruppatoPerPeso().get(5).toString());
		assertEquals(null, this.borsa.getContenutoRaggruppatoPerPeso().get(3));
		Map<Integer, Set<Attrezzo>> exm = new HashMap<>();
		exm.put(5, ex2);
		exm.put(2, ex);
		assertEquals(exm.toString(), this.borsa.getContenutoRaggruppatoPerPeso().toString());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		this.borsa.addAttrezzo(attrezzo1);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo0", 2);
		this.borsa.addAttrezzo(attrezzo4);
		SortedSet<Attrezzo> ex = new TreeSet<>(new ComparatorePesoNome());
		ex.add(attrezzo4);
		ex.add(attrezzo3);
		ex.add(attrezzo1);
		assertEquals(ex.toString(),this.borsa.getSortedSetOrdinatoPerPeso().toString());
		
	}
	
	
}
