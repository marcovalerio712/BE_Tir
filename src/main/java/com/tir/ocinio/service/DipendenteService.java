package com.tir.ocinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;
import com.tir.ocinio.repository.dao.DipendenteDAO;
import com.tir.ocinio.util.EmailUtils;

@Service
public class DipendenteService {

	@Autowired
	private DAO<Dipendente> dipDao;
	
	@Autowired
	private EmailUtils mail;
	
	public List<Dipendente> getAllDipendenti() {
		var dipendenti = dipDao.getAll();
		return dipendenti;
	}

	public Dipendente getDipendenteById(Long id) {
		
		var dipendente = dipDao.getById(id);
		return dipendente;
		
	}
	
	private String generateLink(String token) {
		
		return "http://localhost:4200/confirm/" + token;
		
	}
	
	private void sendRegistrationConfirm(Dipendente dip) {
		var token = ((DipendenteDAO) dipDao).getToken(dip.getId());
		
		var header = "Conferma registrazione per ProgTir";
		var message = "Benvenuto su ProgTir!\n "
					+ "Per confermare la tua registrazione, clicca sul segiente link:\n"
					+ generateLink(token);
		
		new Thread()
		{
		    public void run() {
		    	mail.sendEmail(dip.getEmail(), header, message);
		    }
		}.start();
	}
	
	public Dipendente registerDipendente(Dipendente dip) {
		dip = dipDao.insert(dip);
		sendRegistrationConfirm(dip);
		return dip;
			
	}
	
	public Dipendente updateDipendente(Dipendente dip) {
		return dipDao.update(dip);
	}
	
	public void deleteDipendente(Long id) {
		
		dipDao.delete(id);
		
	}
	
	public void confirmRegistration(String token) {
		((DipendenteDAO) dipDao).confirmToken(token);
	}
	
}
