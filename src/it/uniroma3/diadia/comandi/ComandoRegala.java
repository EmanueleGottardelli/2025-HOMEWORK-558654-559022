package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{
	private final static String NOME = "regala";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		Attrezzo regalo;
		regalo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		
		if(this.getParametro() == null) {
			this.getIO().mostraMessaggio("Che attrezzo vuoi regalare?");
		} else {
			if(personaggio != null) {
				this.getIO().mostraMessaggio(personaggio.riceviRegalo(regalo, partita));
				partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			} else {
				this.getIO().mostraMessaggio("Non c'e' nessuno qui!");
			 }
		}
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
