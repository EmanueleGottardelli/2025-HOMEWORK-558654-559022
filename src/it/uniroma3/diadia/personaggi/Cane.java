package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private final static String MESSAGGIO_CANE = "bau bau, ti è stato tolto un CFU!";
	private final static String MESSAGGIO_REGALO = "Mi hai fatto un buon regalo, eccone uno per te!";
	private final static String CIBO_PREFERITO = "osso";
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		
			if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
				msg = MESSAGGIO_REGALO;
				partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare",2));
		} else 
			msg = this.agisci(partita);
		
		 
		return msg;
	}
	
	

}
