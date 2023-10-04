package com.tir.ocinio.repository.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.repository.mapper.CommessaRowMapper;
import com.tir.ocinio.repository.query.CommessaQuery;


@Repository
public class CommessaDAO implements DAO<Commessa> {

	@Autowired
	private JdbcTemplate template;

	@Override
	public Commessa getById(Long id) {
		String query = String.format(CommessaQuery.oneCommessa, id);
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

	@Override
	public Commessa insert(Commessa t) {
		Commessa newCommessa = null;
		
		var function = new SimpleJdbcCall(template).
							withCatalogName("GRUPPO_3").
							withFunctionName("F_INSERT_COMMESSE");
		
		var newId = function.executeFunction(BigDecimal.class, t.getTipo(), t.getDurata(), t.getDescrizione(), t.getImportoContratto(), t.getDataInizio(), t.getDataFine(), t.getCliente(), t.isAttivo()).longValue(); 
		//metodo della classe BidDecimal che ritorna il corrispettivo valore messo in una variabile di tipo
		
		newCommessa = getById(newId);
		
		return newCommessa;
	}

	@Override
	public void delete(Long id) {
		// vuoto
		
	}

	@Override
	public Commessa update(Commessa t) {
		// TODO Auto-generated method stub
		return null;
	}

}
