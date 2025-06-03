package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.Configuratore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = Configuratore.getCFU();
//	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public boolean prendiAttrezzo(Attrezzo a) {
		return this.borsa.addAttrezzo(a);
	}
	
	public Attrezzo posaAttrezzo(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);	
	}
	
	public boolean isVivo() {
		return this.cfu != 0;
	}
}
