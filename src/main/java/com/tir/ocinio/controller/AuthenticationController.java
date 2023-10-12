package com.tir.ocinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.entity.JwtAuthenticationResponse;
import com.tir.ocinio.service.AuthenticationServiceImpl;
import com.tir.ocinio.service.DipendenteServiceImpl;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationServiceImpl authService;
	
	@Autowired
	private DipendenteServiceImpl dipService;
	
	@PostMapping("")
	public ResponseEntity<Dipendente> registerDipendente(@RequestBody Dipendente dip){
		dip = dipService.registerDipendente(dip);
		return ResponseEntity.ok(dip);
	}
	
	@PostMapping("/confirm/{token}")
	public ResponseEntity<Object> confirmRegistration(@PathVariable("token") String token){
		dipService.confirmRegistration(token);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody Dipendente dip ){
		return ResponseEntity.ok(authService.authenticate(dip));
		
	}
}
