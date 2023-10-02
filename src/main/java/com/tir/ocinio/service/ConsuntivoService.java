package com.tir.ocinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tir.ocinio.entity.Consuntivo;
import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;

public class ConsuntivoService {

	@Autowired
	private DAO<Consuntivo> conDao;
	
	@Autowired
	private DAO<Dipendente> dipDao;
	
	
	public List<Consuntivo> getAllConsuntivi(){
		
		var consuntivi = conDao.getAll();
		
		for(var con : consuntivi) {
			
			con.setDipendente(dipDao.getById(con.getDipendente().getId()));
			
		}
		
		
		return consuntivi;
	}
}
