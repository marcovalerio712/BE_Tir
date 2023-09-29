package com.tir.ocinio.entity;

import java.time.LocalDateTime;

public class Consuntivo {

	private long id;
	private LocalDateTime orario_inizio;
	private LocalDateTime orario_fine;
	private String tipologia;
	private Dipendente id_dipendente;

	public Consuntivo(LocalDateTime orario_inizio, LocalDateTime orario_fine, String tipologia,
			Dipendente id_dipendente) {
		super();
		this.orario_inizio = orario_inizio;
		this.orario_fine = orario_fine;
		this.tipologia = tipologia;
		this.id_dipendente = id_dipendente;
	}

	public Consuntivo() {

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

	public Dipendente getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(Dipendente id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	@Override
	public String toString() {
		return "Consuntivo [id=" + id + ", orario_inizio=" + orario_inizio + ", orario_fine=" + orario_fine
				+ ", tipologia=" + tipologia + ", id_dipendente=" + id_dipendente + "]";
	}



}
