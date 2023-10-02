package com.tir.ocinio.repository.query;

public class AssegnazioneQuery {
	
	public static String allAssegnazioni = "SELECT a.id_dipendente ass_id_dipendente, a.id_commessa ass_id_commesa, a.competenza ass_competenza, a.attivo ass_attivo FROM ASSEGNAZIONI a";
	
	public static String allAssegnazioniAttive = "SELECT a.id_dipendente ass_id_dipendente, a.id_commessa ass_id_commesa, a.competenza ass_competenza, a.attivo ass_attivo FROM ASSEGNAZIONI a WHERE a.attivo = 1";
	
	public static String oneAssegnazioneByDip = allAssegnazioni + "WHERE a.id_dipendente = ";

	public static String oneAssegnazioneByCom = allAssegnazioni + "WHERE a.id_commessa = ";
	
}
