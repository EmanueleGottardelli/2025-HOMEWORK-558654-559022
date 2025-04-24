package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * stampa le informazioni 
 * sulla stanza corrente 
 * e sullo stato della partita
 */

public class ComandoGuarda implements Comando {
	static final String NOME = "guarda";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu());	
	}

	@Override
	public void setParametro(String parametro) {
	
	}
	
	@Override
	public String getParametro() {
		return null;
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
