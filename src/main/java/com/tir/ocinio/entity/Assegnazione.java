package com.tir.ocinio.entity;

public class Assegnazione {
	
	private Dipendente dipendente;
	
	private Commessa commessa;
	
	private Long competenza;
	
	private Long attivo;

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Commessa getCommessa() {
		return commessa;
	}

	public void setCommessa(Commessa commessa) {
		this.commessa = commessa;
	}

	public Long getCompetenza() {
		return competenza;
	}

	public void setCompetenza(Long competenza) {
		this.competenza = competenza;
	}

	public Long getAttivo() {
		return attivo;
	}

	public void setAttivo(Long attivo) {
		this.attivo = attivo;
	}
	
	
	
}
