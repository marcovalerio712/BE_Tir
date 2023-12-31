package com.tir.ocinio.entity;

public class Dipendente {

	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String cf;
	
	private String email;
	
	private String password;
	
	private String telefono;
	
	private Long id_tariffario;
	
	private byte registrato;
	
	private byte attivo;
	
	
	public Dipendente() {}

	public Dipendente(Long id, String nome, String cognome, String cf, String email, String password, String telefono,
			Long id_tariffario, byte registrato, byte attivo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.id_tariffario = id_tariffario;
		this.registrato = registrato;
		this.attivo = attivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId_tariffario() {
		return id_tariffario;
	}

	public void setId_tariffario(Long id_tariffario) {
		this.id_tariffario = id_tariffario;
	}

	public byte getRegistrato() {
		return registrato;
	}

	public void setRegistrato(byte registrato) {
		this.registrato = registrato;
	}

	public byte getAttivo() {
		return attivo;
	}

	public void setAttivo(byte attivo) {
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", id_tariffario=" + id_tariffario
				+ ", registrato=" + registrato + ", attivo=" + attivo + "]";
	}
	
	
}
