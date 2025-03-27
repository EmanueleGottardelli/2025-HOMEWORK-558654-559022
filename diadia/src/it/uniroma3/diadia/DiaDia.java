package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do	{	
			istruzione = io.leggiRiga();
		}
		while (!processaIstruzione(istruzione));
		
		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				if (prossimaStanza == null) 
					io.mostraMessaggio("Direzione inesistente");
				else {
					this.partita.setStanzaCorrente(prossimaStanza);
						int cfu = this.partita.getGiocatore().getCfu();
							this.partita.getGiocatore().setCfu(cfu--);
				}
				io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}
	
	/**
	 * Cerca di trovare un attrezzo. Se è presente lo aggiunge alla borsa 
	 * e lo rimuove dalla stanza
	 */
	
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		else {	
			Attrezzo attrezzo = null;
			attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(attrezzo == null)
				io.mostraMessaggio("Questo attrezzo non è presente nella stanza!");
			else {
					if(this.partita.getGiocatore().prendiAttrezzo(attrezzo))
						this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
					io.mostraMessaggio("Attrezzo preso con successo!");
				}
		}
		
	}
	
	/**
	 * Cerca di trovare un attrezzo nella borsa del giocatore. Selo trova lo aggiunge
	 * alla stanza e lo rimuove dalla borsa
	 */
	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Che attrezzo vuoi posare?");
		else {
			Attrezzo attrezzo = null;
			attrezzo = this.partita.getGiocatore().posaAttrezzo(nomeAttrezzo);
			if(attrezzo == null)
				io.mostraMessaggio("Questo attrezzo non è prente nella borsa!");
			else {
				if(this.partita.getStanzaCorrente().addAttrezzo(attrezzo))
					io.mostraMessaggio("Attrezzo posato con successo");
			}
		}
	}
	
	/**
	 * Comando "Fine".
	 */
	
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}