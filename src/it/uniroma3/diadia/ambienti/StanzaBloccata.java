package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private Direzione direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, Direzione direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(direzioneBloccata.equals(dir) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = new String();
		bloccata = "Direzione bloccata: "+direzioneBloccata+"\nAttrezzo sbloccante: "+attrezzoSbloccante;
		if(!this.hasAttrezzo(attrezzoSbloccante)) {
			return bloccata;
		}
		return super.getDescrizione();
	}
}
