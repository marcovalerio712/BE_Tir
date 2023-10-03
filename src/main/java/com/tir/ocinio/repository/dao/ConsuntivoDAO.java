package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tir.ocinio.entity.Consuntivo;
import com.tir.ocinio.repository.mapper.ConsuntivoRowMapper;
import com.tir.ocinio.repository.query.ConsuntivoQuery;

@Repository
public class ConsuntivoDAO implements DAO<Consuntivo>{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Consuntivo getById(Long id) {
		String query = String.format(ConsuntivoQuery.oneConsuntivo, id);
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
		String query = ConsuntivoQuery.countConsuntivi;
		var counter = template.queryForObject(query, Integer.class);
		return counter;
	}

	@Override
	public Consuntivo insert(Consuntivo t) {
		
		var function = new SimpleJdbcCall(template).
				withCatalogName("GRUPPO_2").
				withFunctionName("P_INSERT_CONSUNTIVI");
		
		var newId = function.executeFunction(BigDecimal.class, );
		
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
