package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class IOSimulatorTest {
	private IOSimulator ios;
	private DiaDia gioco;
	
	

	@Test
	public void test() throws Exception {
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		List<String> comandi = new ArrayList<>();
		comandi.add("prendi martello");
		comandi.add("vai sud");
		ios = new IOSimulator(comandi);
		gioco = new DiaDia(labirinto,ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti().get(0), ""+
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.");
		assertEquals(ios.getMessaggiProdotti().get(1) , "L'attrezzo è stato preso con successo!");
		assertEquals(ios.getMessaggiProdotti().get(3), "Hai vinto!");
		
	}

	@Test
	public void test2()	throws Exception {
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		List<String> comandi2 = new ArrayList<>();
		comandi2.add("anjknk");
		comandi2.add("fine");
		ios = new IOSimulator(comandi2);
		gioco = new DiaDia(labirinto,ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti().get(1), "Comando non valido!");
		assertEquals(ios.getMessaggiProdotti().get(2), "Grazie di aver giocato!");
		
	}
	
	@Test
	public void test3() throws Exception {
		Labirinto labirinto = new Labirinto.LabirintoBuilder("labirinto.txt").getLabirinto();
		List<String> comandi3 = new ArrayList<>();
		comandi3.add("prendi");
		comandi3.add("prendi martello");
		comandi3.add("posa");
		comandi3.add("vai");
		comandi3.add("vai ovest");
		comandi3.add("posa martello");
		comandi3.add("fine");
		ios = new IOSimulator(comandi3);
		gioco = new DiaDia(labirinto, ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti().get(1), "Che attrezzo vuoi prendere?");
		assertEquals(ios.getMessaggiProdotti().get(3), "Che attrezzo vuoi posare?");
		assertEquals(ios.getMessaggiProdotti().get(4), "Dove vuoi andare?");
		assertEquals(ios.getMessaggiProdotti().get(5), "Direzione inesistente");
		assertEquals(ios.getMessaggiProdotti().get(6), "Attrezzo posato con successo!");
		assertEquals(ios.getMessaggiProdotti().get(7), "Grazie di aver giocato!");
		
	}
}
