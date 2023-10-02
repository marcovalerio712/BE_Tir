package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tir.ocinio.entity.Assegnazione;

public class AssegnazioneDAO implements DAO<Assegnazione>{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Assegnazione getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Assegnazione getAssById(Long id_dip, Long id_com) {

		return null;
	}
	
	public Assegnazione getAssById_Dip() {
		return null;

	}
	
	public Assegnazione getAssById_Com() {
		return null;
	}

	@Override
	public List<Assegnazione> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Assegnazione> getAllAttive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Assegnazione insert(Assegnazione t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Assegnazione update(Assegnazione t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void deleteAss(Integer id_dip, Integer id_com) {
		
	}

}
