package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	private final static String NOME = "saluta";
	
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if(personaggio != null) {
				this.getIO().mostraMessaggio(personaggio.saluta());
			}
		else 
			this.getIO().mostraMessaggio("Non c'e' nessuno in questa stanza!");
		}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
