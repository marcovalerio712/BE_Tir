package com.tir.ocinio.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tir.ocinio.entity.Assegnazione;
import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.entity.Task;

public class TaskRowMapper implements RowMapper<Task>{
	
	private CommessaRowMapper commessaMapper = new CommessaRowMapper();
	private DipendenteRowMapper dipendenteMapper = new DipendenteRowMapper();

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		var task = new Task();
		var dipendente = new Dipendente(rs.getLong("ass_id_dipendente"));
		var commessa = new Commessa(rs.getLong("ass_id_commessa"));
		
		
		task.setId(rs.getLong("tas_id"));
		task.setDescrizione(rs.getString("tas_descrizione"));
		task.setNome(rs.getString("tas_nome"));
		task.setDataAssegnazione(rs.getDate("tas_data_assegnazione"));
		task.setDataConsegna(rs.getDate("tas_data_consegna"));
		task.setAssegnazione(new Assegnazione(rs.getLong("tas_id_assegnazione")));
		
		return task;
	}

}
