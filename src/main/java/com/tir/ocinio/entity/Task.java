package com.tir.ocinio.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Task {
	private Long id;
	private String descrizione;
	private String nome;
	private Date dataAssegnazione;
	private Date dataConsegna;
	
	private Dipendente dipendente;
	private Commessa commessa;
	
    private List<Dipendente> dipendentiAssegnati = new ArrayList<Dipendente>();


	public long getId() {
		return id;
	}
	
	
	public void setId(Long l) {
		this.id = l;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}
	
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Date getDataAssegnazione() {
		return dataAssegnazione;
	}
	
	
	public void setDataAssegnazione(Date dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}
	
	
	public Date getDataConsegna() {
		return dataConsegna;
	}
	
	
	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	
	
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
	
	
	public List<Dipendente> getDipendentiAssegnati() {
		return dipendentiAssegnati;
	}


	public void setDipendentiAssegnati(List<Dipendente> dipendentiAssegnati) {
		this.dipendentiAssegnati = dipendentiAssegnati;
	}
	
	
	public Task() {}

	public Task(String descrizione, String nome, Date dataAssegnazione, Date dataConsegna,
			Dipendente dipendente, Commessa commessa) {
		this.descrizione = descrizione;
		this.nome = nome;
		this.dataAssegnazione = dataAssegnazione;
		this.dataConsegna = dataConsegna;
		this.dipendente = dipendente;
		this.commessa = commessa;
	}
	
	public Task(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", descrizione=" + descrizione + ", nome=" + nome + ", data_assegnazione="
				+ dataAssegnazione + ", data_consegna=" + dataConsegna + ", dipendente=" + dipendente + ", commessa="
				+ commessa + ", dipendentiAssegnati=" + dipendentiAssegnati + "]";
	}
	
	
	



	
	
	
	
	
	
	

}
