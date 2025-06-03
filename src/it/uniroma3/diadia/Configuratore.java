package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuratore {

	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "peso_max_borsa";
	private static final String CFU = "cfu_iniziali";
	private static final String ATTREZZI_MAX = "attrezzi_max_stanza";
	private static final String SOGLIA_MAGICA_DEFAULT = "soglia_magica_default";
	private static Properties prop = null;
	
	public static int getCFU() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(PESO_MAX));
	}
	
	public static int getAttrezziMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(ATTREZZI_MAX));
	}
	
	public static int getSogliaMagicaDefault() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(SOGLIA_MAGICA_DEFAULT));
	}
	
	private static void carica() {
        prop = new Properties();
        try (InputStream input = Configuratore.class.getClassLoader().getResourceAsStream(DIADIA_PROPERTIES)) {
            if (input == null) {
                throw new IOException("File " + DIADIA_PROPERTIES + " non trovato nel classpath");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}