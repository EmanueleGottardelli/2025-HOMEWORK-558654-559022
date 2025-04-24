package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai implements Comando{
	private String direzione;
	private IO io;
	static final private String NOME = "vai";
	
	@Override
	public void esegui (Partita partita){
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?");
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				if (prossimaStanza == null) 
					io.mostraMessaggio("Direzione inesistente");
				else {
					partita.setStanzaCorrente(prossimaStanza);
						int cfu = partita.getGiocatore().getCfu();
							partita.getGiocatore().setCfu(cfu--);
				}
				io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
	@Override 
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
