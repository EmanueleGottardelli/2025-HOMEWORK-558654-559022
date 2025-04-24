package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Cerca di trovare un attrezzo nella borsa del giocatore. Se lo trova lo aggiunge
 * alla stanza e lo rimuove dalla borsa
 */

public class ComandoPosa implements Comando {
	static final private String NOME = "posa";
	private IO io;
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Che attrezzo vuoi posare?");
		else {
			Attrezzo a = partita.getGiocatore().posaAttrezzo(nomeAttrezzo);
			if(a == null)
				io.mostraMessaggio("Attrezzo inesistente!");
			else {
				if(partita.getStanzaCorrente().addAttrezzo(a))
					io.mostraMessaggio("Attrezzo posato con successo!");
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
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
