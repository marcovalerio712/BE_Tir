package com.tir.ocinio.entity;

public class Ruolo{
	private long id;
	private int compenso;
	private String anzianita;

	public Ruolo(int compenso, String anzianita) {
		this.compenso = compenso;
		this.anzianita = anzianita;
	}

	public Ruolo() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCompenso() {
		return compenso;
	}

	public void setCompenso(int compenso) {
		this.compenso = compenso;
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

