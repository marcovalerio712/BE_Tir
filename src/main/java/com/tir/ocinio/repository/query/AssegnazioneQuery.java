package com.tir.ocinio.repository.query;

public class AssegnazioneQuery {
	
	public static String allAssegnazioni = "SELECT a.id_dipendente ass_id_dipendente, a.id_commessa ass_id_commessa, a.competenza ass_competenza, a.attivo ass_attivo, a.id ass_id FROM ASSEGNAZIONI a ";
	
	public static String allAssegnazioniAttive = "SELECT a.id ass_id a.id_dipendente ass_id_dipendente, a.id_commessa ass_id_commessa, a.competenza ass_competenza, a.attivo ass_attivo FROM ASSEGNAZIONI a WHERE a.attivo = 1";
	
	public static String AllAssegnazioniByDip = allAssegnazioni + "WHERE a.id_dipendente = %d";

	public static String AllAssegnazioniByCom = allAssegnazioni + "WHERE a.id_commessa = %d";
	
	public static String oneAssegnazione = allAssegnazioni + "WHERE a.id = %d";
	
}
