package com.tir.ocinio.repository.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.repository.mapper.CommessaRowMapper;
import com.tir.ocinio.repository.query.CommessaQuery;



public class CommessaDAO implements DAO<Commessa> {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Commessa getById(Long id) {
		String query = CommessaQuery.oneCommessa + id;
		var commessa = template.queryForObject(query, new CommessaRowMapper());
		return commessa;
	}

	@Override
	public List<Commessa> getAll() {
		String query = CommessaQuery.allCommesse;
		var commessa = template.query(query, new CommessaRowMapper());
		return commessa;
	}

	@Override
	public int count() {
		String query = CommessaQuery.countCommessa;
		var counter = template.queryForObject(query, Integer.class);
		return counter;
	}

}
