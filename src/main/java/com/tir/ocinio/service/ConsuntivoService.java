package com.tir.ocinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tir.ocinio.entity.Consuntivo;
import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;

@Service
public class ConsuntivoService {

	@Autowired
	private DAO<Consuntivo> conDao;
	
	@Autowired
	private DAO<Dipendente> dipDao;
	
	public Consuntivo getConsuntivoById(long id) {
		
		var consuntivo = conDao.getById(id);
		
		consuntivo.setDipendente(dipDao.getById(consuntivo.getDipendente().getId()));
		
		return consuntivo;
	}
	
	
	public List<Consuntivo> getAllConsuntivi(){
		
		var consuntivi = conDao.getAll();
		
		for(var con : consuntivi) {
			
			con.setDipendente(dipDao.getById(con.getDipendente().getId()));
			
		}
		
		return consuntivi;
	}
	
	public Integer getCountConsuntivi() {
		var counterConsuntivi = conDao.count();
		return counterConsuntivi;
	}
}
