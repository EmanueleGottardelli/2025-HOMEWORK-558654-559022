package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
  * Questa classe il Labirinto per la partita del gioco DiaDia
  * 
  * @author studente di poo
  * @version base 
  *
  */

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	private Labirinto (String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
//	 /**
//     * Crea tutte le stanze e le porte di collegamento
//     */
//   private void creaStanze() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//
//        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//
//		// il gioco comincia nell'atrio
//        this.stanzaIniziale = atrio;  
//		this.stanzaVincente = biblioteca;
//    }
//   

	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
		return new LabirintoBuilder(labirinto);
	}
	
    public void setStanzaIniziale(Stanza stanza){
	   this.stanzaIniziale = stanza;
    }
   
    public Stanza getStanzaIniziale() {
	  return this.stanzaIniziale; 
    }
   
    public void setStanzaVincente(Stanza stanza) {
	   this.stanzaVincente = stanza;
    }
   
    public Stanza getStanzaVincente() {
	   return this.stanzaVincente;
    }
    /* classe nidificata labirintoBuilder per la creazione di un labirinto */
   
    public static class LabirintoBuilder {
    	private Stanza stanzaCorrente;
    	private Labirinto labirinto;
    	private Map<String, Stanza> nome2stanza;
    	
    	public LabirintoBuilder (String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
    		this.labirinto = new Labirinto(labirinto);
    		this.nome2stanza = new HashMap<String,Stanza>();
    	}
    	
    	public Labirinto getLabirinto() {
    		return this.labirinto;
    	}
    	
    	public Map<String, Stanza> getNome2Stanza(){
    		return this.nome2stanza;
    	}
    	
    	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
    		Stanza si = new Stanza(nomeStanza);
    		this.labirinto.setStanzaIniziale(si);
    		this.nome2stanza.put(si.getNome(), si);
    		this.stanzaCorrente = si;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
    		Stanza sv = new Stanza(nomeStanzaVincente);
    		this.labirinto.setStanzaVincente(sv);
    		this.nome2stanza.put(sv.getNome(), sv);
    		this.stanzaCorrente = sv;
    		return this;
    	}
    	
    	public LabirintoBuilder addAdiacenza(String stanza1, String stanza2, Direzione direzione) {
    		Stanza s1 = this.nome2stanza.get(stanza1);
    		Stanza s2 = this.nome2stanza.get(stanza2);
    		
    		s1.impostaStanzaAdiacente(direzione, s2);
    		
    		return this;
    	}
    	
    	public LabirintoBuilder addStanza(String nomeStanza) {
    		Stanza ns = new Stanza(nomeStanza);
    		this.nome2stanza.put(ns.getNome(), ns);
    		this.stanzaCorrente = ns;
    		return this;
    	}
    	
    	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
    		Attrezzo na = new Attrezzo(nomeAttrezzo, peso);
    		//this.nome2stanza.get(stanzaCorrente.getNome()).addAttrezzo(na);
    		if(this.stanzaCorrente == null)
    			return this;
    		
    		this.stanzaCorrente.addAttrezzo(na);
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
    		StanzaMagica nsm = new StanzaMagica(nomeStanza, sogliaMagica);
    		this.nome2stanza.put(nsm.getNome(), nsm);
    		this.stanzaCorrente = nsm;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaBloccata(String nomeStanza, Direzione direzioneBloccata, String attrezzoSbloccante) {
    		StanzaBloccata nsb = new StanzaBloccata(nomeStanza, direzioneBloccata, attrezzoSbloccante);
    		this.nome2stanza.put(nsb.getNome(),nsb);
    		this.stanzaCorrente = nsb;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaBuia(String nomeStanza, String attrezzoLucente) {
    		StanzaBuia nsbu = new StanzaBuia(nomeStanza, attrezzoLucente);
    		this.nome2stanza.put(nsbu.getNome(), nsbu);
    		this.stanzaCorrente = nsbu;
    		return this;
    	}

    }
	
}
