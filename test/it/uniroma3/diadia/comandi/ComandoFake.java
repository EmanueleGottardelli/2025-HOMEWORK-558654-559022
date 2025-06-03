package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFake extends AbstractComando{
	private final static String NOME = "fake";
	
	@Override
	public String getNome() {
		return NOME;
	}


	@Override
	public void esegui(Partita partita) {
		partita.setFinita();	
	}
	
	

}
