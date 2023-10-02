package com.tir.ocinio.entity;

import java.time.LocalDateTime;

public class Consuntivo {

	private long id;
	private LocalDateTime orario_inizio;
	private LocalDateTime orario_fine;
	private String tipologia;
	private Dipendente dipendente;

	public Consuntivo(LocalDateTime orario_inizio, LocalDateTime orario_fine, String tipologia,
			Dipendente dipendente) {
		super();
		this.orario_inizio = orario_inizio;
		this.orario_fine = orario_fine;
		this.tipologia = tipologia;
		this.dipendente = dipendente;
	}

	public Consuntivo() {

	}
	
	public Consuntivo(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getOrario_inizio() {
		return orario_inizio;
	}

	public void setOrario_inizio(LocalDateTime orario_inizio) {
		this.orario_inizio = orario_inizio;
	}

	public LocalDateTime getOrario_fine() {
		return orario_fine;
	}

	public void setOrario_fine(LocalDateTime orario_fine) {
		this.orario_fine = orario_fine;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	@Override
	public String toString() {
		return "Consuntivo [id=" + id + ", orario_inizio=" + orario_inizio + ", orario_fine=" + orario_fine
				+ ", tipologia=" + tipologia + ", id_dipendente=" + dipendente + "]";
	}



}
