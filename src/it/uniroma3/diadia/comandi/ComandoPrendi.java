package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	static final private String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		if(this.getParametro() == null)
			this.getIO().mostraMessaggio("Che attrezzo vuoi prendere?");
		else {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
		if(a == null) {
			this.getIO().mostraMessaggio("Questo attrezzo non è presente nella stanza!");
		}
		else if(partita.getGiocatore().prendiAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
			this.getIO().mostraMessaggio("L'attrezzo è stato preso con successo!");
		 }
	   }	
	 }
	
	@Override 
	public String getNome() {
		return NOME;
	}

}
