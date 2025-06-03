package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{
	private IO io;
	
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}

	public Comando costruisciComando(String istruzione) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null; //nome comando da eseguire es. 'vai'
		String parametro = null; //eventuale parametro es. 'sud'
		Comando comando = null;
		
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
			nomeClasse += nomeComando.substring(1);
			comando = (Comando)Class.forName(nomeClasse).newInstance();
			comando.setParametro(parametro);
			comando.setIO(io);
			} catch (Exception e) {
			comando = new ComandoNonValido();
			comando.setIO(io);
			}
		return comando;
	}

}
