package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
	
	private List<String> righeLette;
	private int numeroRigheLette;
	private List<String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(List<String>righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.numeroRigheLette = 0;
		this.messaggiProdotti = new ArrayList<>();
		this.indiceMessaggiMostrati = 0;
	}
	
	public List<String> getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
	public List<String> getRigheLette() {
		return this.righeLette;
	}
 
	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti.add(indiceMessaggiProdotti, msg);
		this.indiceMessaggiProdotti++;
	}
	
	@Override
	public String leggiRiga() {
		String riga = this.righeLette.get(this.numeroRigheLette);
		this.numeroRigheLette++;
		return riga;
	}
	
	public String nextMessaggio() {
		String messaggioNext = this.messaggiProdotti.get(this.indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return messaggioNext;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
}
