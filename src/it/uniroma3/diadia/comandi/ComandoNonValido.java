package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	static final private String NOME = "non valido";

	@Override
	public void esegui(Partita partita) {
		this.getIO().mostraMessaggio("Comando non valido!");
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
