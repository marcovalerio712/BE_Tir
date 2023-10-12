package com.tir.ocinio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tir.ocinio.entity.JwtAuthenticationResponse;
import com.tir.ocinio.repository.dao.DAO;
import com.tir.ocinio.repository.dao.DipendenteDAO;
import com.tir.ocinio.util.EmailUtils;

@Service
public class DipendenteServiceImpl implements DipendenteService {

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
		// casting necessario per l'aggiunta dei metodi che non rispecchiano
		// l'interfaccia

		var header = "Conferma registrazione per ProgTir";
		var message = "Benvenuto su ProgTir!\n " + "Per confermare la tua registrazione, clicca sul seguente link:\n"
				+ generateLink(token);

		new Thread() // consigliato per tempi di risposta lunghi della mail
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
	public UserDetailsService userDetailsService() {

		return new UserDetailsService() {

			public UserDetails loadUserByUsername(String email) {
				return ((DipendenteDAO) dipDao).findByEmail(email);
			}
		};
	}


}
