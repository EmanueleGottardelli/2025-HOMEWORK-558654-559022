package it.uniroma3.diadia.giocatore;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.Configuratore;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
	//public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * 
	 * @param attrezzo
	 * @return true se l'attrezzo è statp aggiunto correttamente false se non è stato aggiunto 
	 */
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null || this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		else if(this.attrezzi.add(attrezzo)) {
			this.numeroAttrezzi++;
			return true;	
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return peso massimo della borsa
	 */
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	/**
	 * @param la stringa nome dell'attrezzo
	 * @return se c'è ritorna l'attrezzo
	 */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			attrezzo = it.next();
			if(nomeAttrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				return attrezzo;
		}
		return null;
	}
	
//	private List<Attrezzo> getAttrezzi(){
//		return this.attrezzi;
//	}
	
	/**
	 * @return il peso corrente della borsa
	 */
	
	public int getPeso(){
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi) {
			pesoTotale += a.getPeso();
		}
		return pesoTotale;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoRimosso = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			attrezzoRimosso = it.next();
			if(nomeAttrezzo != null && attrezzoRimosso.getNome().equals(nomeAttrezzo)) {
				it.remove();
				return attrezzoRimosso;
			}		
		}
		return null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
			}
			else
				s.append("Borsa vuota");
				return s.toString();
		}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ris = new ArrayList<>(this.attrezzi);
		Collections.sort(ris, new ComparatorePesoNome());
		return ris;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.attrezzi);
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> ris = new HashMap<>();
		
		for(Attrezzo a : this.attrezzi) {
			if(ris.containsKey(a.getPeso())) {
				ris.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> sa = new HashSet<>();
				sa.add(a);
				ris.put(a.getPeso(), sa);
			}
		}
		return ris;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> ris = new TreeSet<>(new ComparatorePesoNome());
		ris.addAll(this.attrezzi);
		return ris;
	}
}

