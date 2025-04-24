package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private String[] righeLette;
	private int numeroRigheLette;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.numeroRigheLette = 0;
		this.messaggiProdotti = new String[50*40];
		this.indiceMessaggiMostrati = 0;
	}
	
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
//	public String[] getRigheLette() {
//		return this.righeLette;
//	}
 
	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[this.indiceMessaggiProdotti] = msg;
		this.indiceMessaggiProdotti++;
	}
	
	@Override
	public String leggiRiga() {
		String riga = this.righeLette[this.numeroRigheLette];
		this.numeroRigheLette++;
		return riga;
	}
	
	public String nextMessaggio() {
		String messaggioNext = this.messaggiProdotti[indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return messaggioNext;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati <= this.indiceMessaggiProdotti;
	}
}
