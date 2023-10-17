package com.tir.ocinio.enumeration;

public enum Ruolo {

	JUNIOR("Junior"), MIDDLE("Middle"), SENIOR("Senior"), HR("HR");
	
	public final String nome;
	
	private Ruolo(String nome) {
		this.nome = nome;
	}
	
}
