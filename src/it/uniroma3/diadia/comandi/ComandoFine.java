package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public class ComandoFine extends AbstractComando {
	static final private String NOME = "fine";
    static final private String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.getIO().mostraMessaggio(MESSAGGIO_FINE);
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
