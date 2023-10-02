package com.tir.ocinio.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tir.ocinio.entity.Assegnazione;

public class AssegnazioneRowMapper implements RowMapper<Assegnazione>{
	
	private DipendenteRowMapper dipendenteMapper = new DipendenteRowMapper();
	
	private CommessaRowMapper commessaMapper = new CommessaRowMapper();

	@Override
	public Assegnazione mapRow(ResultSet rs, int rowNum) throws SQLException {

		var assegnazione = new Assegnazione();		
		
		assegnazione.setDipendente(dipendenteMapper.mapRow(rs, rowNum));
		assegnazione.setCommessa(commessaMapper.mapRow(rs, rowNum));
		assegnazione.setCompetenza(rs.getLong("ass_competenza"));
		assegnazione.setAttivo(rs.getInt("ass_attivo") == 1);
		
		return assegnazione;
	}

}
