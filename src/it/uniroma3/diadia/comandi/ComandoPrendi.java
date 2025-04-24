package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IO io;
	static final private String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		else {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a == null) {
			io.mostraMessaggio("Questo attrezzo non è presente nella stanza!");
		}
		else if(partita.getGiocatore().prendiAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("L'attrezzo è stato preso con successo!");
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
