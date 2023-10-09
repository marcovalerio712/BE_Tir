package com.tir.ocinio.repository.query;

public class TaskQuery {
	
	public static String allTask = "select t.id tas_id, t.id_assegnazione tas_id_assegnazione, "
			+ "t.descrizione tas_descrizione, t.nome tas_nome, "
			+ "t.data_assegnazione tas_data_assegnazione, t.data_consegna tas_data_consegna"
			+"from Task";

			public static String oneTask = allTask + "and t.id = ";

			public static String countTask = "select count(*) from Task";

}
