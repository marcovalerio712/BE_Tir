package com.tir.ocinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;

@Service
public class DipendenteService {

	@Autowired
	private DAO<Dipendente> dipDao;
	
	public List<Dipendente> getAllDipendenti() {
		var dipendenti = dipDao.getAll();
		return dipendenti;
	}

	public Dipendente getDipendenteById(Long id) {
		
		var dipendente = dipDao.getById(id);
		return dipendente;
		
	}
	
	public Dipendente registerDipendente(Dipendente dip) {
		
		return dipDao.insert(dip);
			
	}
	
	public Dipendente updateDipendente(Dipendente dip) {
		
		return dipDao.update(dip);
	}
	
	public void deleteDipendente(Long id) {
		
		dipDao.delete(id);
		
	}
	
}
