package com.tir.ocinio.entity;

public class TokenRegistrazione {

	private Long id_dipendente;
	
	private String token;
	
	

	public TokenRegistrazione(Long id_dipendente, String token) {
		super();
		this.id_dipendente = id_dipendente;
		this.token = token;
	}

	public Long getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(Long id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenRegistrazione [id_dipendente=" + id_dipendente + ", token=" + token + "]";
	}
	
	
}
