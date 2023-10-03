package com.tir.ocinio.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tir.ocinio.entity.Task;

public class TaskRowMapper implements RowMapper<Task>{
	
	//private CommessaRowMapper commessaMapper = new CommessaRowMapper();
	private DipendenteRowMapper dipendenteMapper = new DipendenteRowMapper();

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		var task = new Task();
		
		
		task.setId(rs.getLong("tas_id"));
		task.setDescrizione(rs.getString("tas_descrizione"));
		task.setNome(rs.getString("tas_nome"));
		task.setDataAssegnazione(rs.getDate("tas_data_assegnazione"));
		task.setDataConsegna(rs.getDate("tas_data_consegna"));
		//task.setCommessa();
		task.setDipendente(null);
		return task;
	}

}
