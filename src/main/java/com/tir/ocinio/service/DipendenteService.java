package com.tir.ocinio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;
import com.tir.ocinio.repository.dao.DipendenteDAO;
import com.tir.ocinio.util.EmailUtils;

@Service
public class DipendenteService implements UserDetailsService{

	@Autowired
	private DAO<Dipendente> dipDao;
	
	@Autowired
	AuthenticationManager authentication;
	
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
		//casting necessario per l'aggiunta dei metodi che non rispecchiano l'interfaccia
		
		var header = "Conferma registrazione per ProgTir";
		var message = "Benvenuto su ProgTir!\n "
					+ "Per confermare la tua registrazione, clicca sul seguente link:\n"
					+ generateLink(token);
		
		new Thread() //consigliato per tempi di risposta lunghi della mail
		{
		    public void run() {
		    	mail.sendEmail(dip.getEmail(), header, message);
		    }
		}.start();
	}
	
	public void confirmRegistration(String token) {
		((DipendenteDAO) dipDao).confirmToken(token);
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 var dip = ((DipendenteDAO) dipDao).findByEmail(email);
		 if(dip == null) {
			 throw new UsernameNotFoundException("Utente non trovato con email: " + email);
		 }
		  return org.springframework.security.core.userdetails.User
	                .withUsername(dip.getEmail())
	                .password(dip.getPassword())
	                .authorities(dip.getRuolo().getAnzianita())  // Assuming Ruolo is an enum of roles
	                .accountExpired(false)
	                .accountLocked(!dip.getAttivo())
	                .credentialsExpired(false)
	                .disabled(!dip.getRegistrato())
	                .build();
	}
	
	 public  void authenticate(String username, String password) throws Exception {
	        try {
	            authentication.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	    }
}
