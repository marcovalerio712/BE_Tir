package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.mapper.DipendenteRowMapper;
import com.tir.ocinio.repository.query.DipendenteQuery;

@Repository
public class DipendenteDAO implements DAO<Dipendente>{

	@Autowired 
	private JdbcTemplate template;
	
	@Override
	public Dipendente getById(Long id) {
		
		String query = DipendenteQuery.oneDipendente + id;
		var dipendente = template.queryForObject(query, new DipendenteRowMapper());
		return dipendente;
	}

	@Override
	public List<Dipendente> getAll() {
		String query = DipendenteQuery.allDipendenti;
		var dipendenti = template.query(query, new DipendenteRowMapper());
		return dipendenti;
	}

	@Override
	public int count() {
		String query = DipendenteQuery.countDipendenti;
		var counter = template.queryForObject(query, Integer.class);
		return counter;
	}

	@Override
	public Dipendente insert(Dipendente t) {
		Dipendente newDipendente = null;
		
		var procedure = new SimpleJdbcCall(template).withProcedureName("GRUPPO_1.F_INSERISCI_DIPENDENTE");
		
		
		
		return newDipendente;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dipendente update(Dipendente t) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
}
