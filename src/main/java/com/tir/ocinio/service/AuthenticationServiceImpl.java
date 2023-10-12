package com.tir.ocinio.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.entity.JwtAuthenticationResponse;
import com.tir.ocinio.repository.dao.DAO;
import com.tir.ocinio.repository.dao.DipendenteDAO;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private DAO<Dipendente> dipDao;
	
	@Autowired
	private JWTService jwtService;
	
//	@Autowired
//	private PasswordEncoder bc;

	@Autowired
	AuthenticationManager authenticationManager;
	
	public JwtAuthenticationResponse authenticate(Dipendente dip) {
		//var criptedP = bc.encode(dip.getPassword());
		var email = dip.getEmail();
		var dipendente = ((DipendenteDAO) dipDao).findByEmail(email);
		//problema qua(authentication)
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, dipendente.getPassword(),dipendente.getAuthorities()));
		var jwt = jwtService.generateToken(dipendente);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), dipendente);
		JwtAuthenticationResponse jwtAuth = new JwtAuthenticationResponse();
		jwtAuth.setToken(jwt);
		jwtAuth.setRefreshToken(refreshToken);
		return jwtAuth;
	}

}
