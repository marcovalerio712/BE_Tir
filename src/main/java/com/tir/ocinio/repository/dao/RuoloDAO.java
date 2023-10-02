package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tir.ocinio.entity.Ruolo;
import com.tir.ocinio.repository.mapper.RuoloRowMapper;
import com.tir.ocinio.repository.query.RuoloQuery;

public class RuoloDAO implements DAO<Ruolo>{

	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Ruolo getById(Long id) {
	
		String query = RuoloQuery.oneRuolo + id;
		
		var ruolo = template.queryForObject(query, new RuoloRowMapper()); 
		
		return ruolo;
	}

	@Override
	public List<Ruolo> getAll() {
		
		String query = RuoloQuery.allRuoli;
		
		var ruoli =  template.query(query, new RuoloRowMapper());
		return ruoli;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ruolo insert(Ruolo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ruolo update(Ruolo t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
