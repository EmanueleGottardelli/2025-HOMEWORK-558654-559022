package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * stampa le informazioni 
 * sulla stanza corrente 
 * e sullo stato della partita
 */

public class ComandoGuarda extends AbstractComando {
	static final String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		this.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.getIO().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu());	
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
