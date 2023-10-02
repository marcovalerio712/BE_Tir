package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tir.ocinio.entity.Cliente;
import com.tir.ocinio.repository.mapper.ClienteRowMapper;
import com.tir.ocinio.repository.query.ClienteQuery;

@Repository
public class ClienteDAO implements DAO<Cliente>{
	
	@Autowired 
	private JdbcTemplate template;
	
	@Override
	public Cliente getById(Long id) {
		
		return null;
	}

	@Override
	public List<Cliente> getAll() {
		String query = ClienteQuery.allClienti;
		var clienti = template.query(query, new ClienteRowMapper());
		return clienti;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente insert(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente update(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
