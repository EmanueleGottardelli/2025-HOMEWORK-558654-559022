package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IOSimulatorTest {
	private IOSimulator ios;
	private DiaDia gioco;
	

	@Test
	public void test() {
		
		String[] comandi = {"prendi osso", "vai nord"};
		ios = new IOSimulator(comandi);
		gioco = new DiaDia(ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti()[0], ""+
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.");
		assertEquals(ios.getMessaggiProdotti()[1] , "L'attrezzo è stato preso con successo!");
		assertEquals(ios.getMessaggiProdotti()[3], "Hai vinto!");
		
	}

	@Test
	public void test2()	{
		String[] comandi2 = {"anjknk","fine"};
		ios = new IOSimulator(comandi2);
		gioco = new DiaDia(ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti()[1], "Comando non valido!");
		assertEquals(ios.getMessaggiProdotti()[2], "Grazie di aver giocato!");
		assertNull(ios.getMessaggiProdotti()[3]);
		
	}
	
	@Test
	public void test3() {
		String[] comandi3 = {"prendi", "prendi osso", "posa", "vai", "vai sud","vai sud", "posa osso", "fine"};
		ios = new IOSimulator(comandi3);
		gioco = new DiaDia(ios);
		gioco.gioca();
		
		assertEquals(ios.getMessaggiProdotti()[1], "Che attrezzo vuoi prendere?");
		assertEquals(ios.getMessaggiProdotti()[3], "Che attrezzo vuoi posare?");
		assertEquals(ios.getMessaggiProdotti()[4], "Dove vuoi andare?");
		assertEquals(ios.getMessaggiProdotti()[6], "Direzione inesistente");
		assertEquals(ios.getMessaggiProdotti()[8], "Attrezzo posato con successo!");
		
	}
}
