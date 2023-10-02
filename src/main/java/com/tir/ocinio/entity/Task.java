package com.tir.ocinio.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Task {
	private long id;
	private String descrizione;
	private String nome;
	private Date data_assegnazione;
	private Date data_consegna;
	
	private Dipendente dipendente;
	private Commessa commessa;
	
    private List<Dipendente> dipendentiAssegnati = new ArrayList<Dipendente>();


	public long getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
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
	
	
	public Date getData_assegnazione() {
		return data_assegnazione;
	}
	
	
	public void setData_assegnazione(Date data_assegnazione) {
		this.data_assegnazione = data_assegnazione;
	}
	
	
	public Date getData_consegna() {
		return data_consegna;
	}
	
	
	public void setData_consegna(Date data_consegna) {
		this.data_consegna = data_consegna;
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

	public Task(String descrizione, String nome, Date data_assegnazione, Date data_consegna,
			Dipendente id_dipendente, Commessa id_commessa) {
		this.descrizione = descrizione;
		this.nome = nome;
		this.data_assegnazione = data_assegnazione;
		this.data_consegna = data_consegna;
		this.dipendente = dipendente;
		this.commessa = commessa;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", descrizione=" + descrizione + ", nome=" + nome + ", data_assegnazione="
				+ data_assegnazione + ", data_consegna=" + data_consegna + ", dipendente=" + dipendente + ", commessa="
				+ commessa + ", dipendentiAssegnati=" + dipendentiAssegnati + "]";
	}
	
	
	



	
	
	
	
	
	
	

}
