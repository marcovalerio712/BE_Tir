package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tir.ocinio.entity.Consuntivo;
import com.tir.ocinio.repository.mapper.ConsuntivoRowMapper;
import com.tir.ocinio.repository.query.ConsuntivoQuery;

public class ConsuntivoDAO implements DAO<Consuntivo>{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Consuntivo getById(Long id) {
	
		String query = ConsuntivoQuery.oneConsuntivo + id;
		var consuntivo = template.queryForObject(query, new ConsuntivoRowMapper());
		
		return consuntivo;
	}

	@Override
	public List<Consuntivo> getAll() {
		String query = ConsuntivoQuery.allConsuntivi;
		var consuntivi = template.query(query, new ConsuntivoRowMapper());
		return consuntivi;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Consuntivo insert(Consuntivo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Consuntivo update(Consuntivo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
