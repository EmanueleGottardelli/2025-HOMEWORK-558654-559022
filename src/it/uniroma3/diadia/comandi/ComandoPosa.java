package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Cerca di trovare un attrezzo nella borsa del giocatore. Se lo trova lo aggiunge
 * alla stanza e lo rimuove dalla borsa
 */

public class ComandoPosa extends AbstractComando {
	static final private String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro() == null)
			this.getIO().mostraMessaggio("Che attrezzo vuoi posare?");
		else {
			Attrezzo a = partita.getGiocatore().posaAttrezzo(this.getParametro());
			if(a == null)
				this.getIO().mostraMessaggio("Attrezzo inesistente!");
			else {
				if(partita.getStanzaCorrente().addAttrezzo(a))
					this.getIO().mostraMessaggio("Attrezzo posato con successo!");
			}
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
