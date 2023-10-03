package com.tir.ocinio.entity;

public class Ruolo{
	private Long id;
	private Float compenso;
	private String anzianita;

	public Ruolo(Float compenso, String anzianita) {
		this.compenso = compenso;
		this.anzianita = anzianita;
	}

	public Ruolo() {

	}
	
	public Ruolo(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getCompenso() {
		return compenso;
	}

	public void setCompenso(float f) {
		this.compenso = f;
	}

	public String getAnzianita() {
		return anzianita;
	}

	public void setAnzianita(String anzianita) {
		this.anzianita = anzianita;
	}

	@Override
	public String toString() {
		return "Ruoli [id=" + id + ", compenso=" + compenso + ", anzianita=" + anzianita + "]";
	}

}

