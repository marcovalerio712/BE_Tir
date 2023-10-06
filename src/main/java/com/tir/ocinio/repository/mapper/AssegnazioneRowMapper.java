package com.tir.ocinio.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tir.ocinio.entity.Assegnazione;
import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.entity.Dipendente;

public class AssegnazioneRowMapper implements RowMapper<Assegnazione>{

	@Override
	public Assegnazione mapRow(ResultSet rs, int rowNum) throws SQLException {

		var assegnazione = new Assegnazione();		
		
		var dipendente = new Dipendente(rs.getLong("ass_id_dipendente"));
		var commessa = new Commessa(rs.getLong("ass_id_commessa"));
		
		assegnazione.setId(rs.getLong("ass_id"));
		assegnazione.setDipendente(dipendente);
		assegnazione.setCommessa(commessa);
		assegnazione.setCompetenza(rs.getLong("ass_competenza"));
		assegnazione.setAttivo(rs.getInt("ass_attivo") == 1);
		
		return assegnazione;
	}

}
