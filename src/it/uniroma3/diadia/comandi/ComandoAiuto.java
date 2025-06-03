package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto extends AbstractComando {
	private static final String NOME = "aiuto";
	private static final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa","guarda","interagisci","saluta","regala"};
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIO().mostraMessaggio(elencoComandi[i]+" ");
		this.getIO().mostraMessaggio(" ");
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
