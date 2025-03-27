package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo attrezzi[];
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * 
	 * @param attrezzo
	 * @return true se l'attrezzo è statp aggiunto correttamente false se non è stato aggiunto 
	 */
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if(this.numeroAttrezzi==10)
			return false;
		this.attrezzi[numeroAttrezzi] = attrezzo;
		numeroAttrezzi++;
		return true;
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
		for(int i = 0; i < this.numeroAttrezzi; i++) 
			if(attrezzi[i].getNome().equals(nomeAttrezzo))
				attrezzo = attrezzi[i];
		return attrezzo;
	}
	
	/**
	 * @return il peso corrente della borsa
	 */
	
	public int getPeso(){
		int peso = 0;
		for(int i = 0; i < numeroAttrezzi; i++)
			peso  += this.attrezzi[i].getPeso();
			
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i = 0; i < this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				for(int j = i; j < this.numeroAttrezzi-1; j++)
					this.attrezzi[j] = this.attrezzi[j+1];
			}
			a = this.attrezzi[i];
			this.attrezzi[this.numeroAttrezzi-1] = null;
			this.numeroAttrezzi--;
		}
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				for (int i= 0; i<this.numeroAttrezzi; i++)
					s.append(attrezzi[i].toString()+" ");
			}
			else
				s.append("Borsa vuota");
				return s.toString();
		}
}
