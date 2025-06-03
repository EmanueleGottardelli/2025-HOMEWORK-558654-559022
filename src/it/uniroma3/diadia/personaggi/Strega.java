package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_NON_SALUTATA = "Per non avermi salutata ti mando nella stanza con meno attrezzi!";
	private static final String MESSAGGIO_SALUTATA = "CIAO! Vai nella stanza con piu' attrezzi!";
	private static final String RISATA = "AHAHAHAHAHAHAH!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza minAttrezzi = stanzeAdiacenti.get(0);
		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		
		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(minAttrezzi.getNumeroAttrezzi() > s.getNumeroAttrezzi())
					minAttrezzi = s;
				if(maxAttrezzi.getNumeroAttrezzi() < s.getNumeroAttrezzi())
					maxAttrezzi = s;
			}
		}
		
		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAttrezzi);
			msg = MESSAGGIO_SALUTATA;	
		}
		else {
			partita.setStanzaCorrente(minAttrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}	
		
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return RISATA;
	}

}
