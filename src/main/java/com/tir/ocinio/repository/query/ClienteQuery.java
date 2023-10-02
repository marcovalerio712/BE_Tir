package com.tir.ocinio.repository.query;

public class ClienteQuery {
	
	public static String allClienti = "select c.id cli_id, c.nome cli_nome, c.p_iva cli_piva, c.telefono cli_telefono " 
									+ " from clienti c";
	
	public static String oneCliente = allClienti + "where c.id = ";
	
	public static String countClienti = "select count(*) from clienti";
	
	//public static String insertCliente = "execute F_INSERISCI_CLIENTE";
	
	

}
