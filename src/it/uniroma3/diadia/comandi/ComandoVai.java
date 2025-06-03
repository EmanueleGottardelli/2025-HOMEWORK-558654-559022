package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai extends AbstractComando{
	static final private String NOME = "vai";
	
	@Override
	public void esegui (Partita partita){
		if(this.getParametro()==null) {
			this.getIO().mostraMessaggio("Dove vuoi andare?");
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
				if (prossimaStanza == null) {
					this.getIO().mostraMessaggio("Direzione inesistente");
					return;
				}
				else {
					partita.setStanzaCorrente(prossimaStanza);
					partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
				}
				this.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	
		}
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
