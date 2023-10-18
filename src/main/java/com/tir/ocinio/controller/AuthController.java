package com.tir.ocinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tir.ocinio.entity.AuthenticationResponse;
import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.service.AuthenticationService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationService auth;
	
	
	@PostMapping("/login")
	private ResponseEntity<AuthenticationResponse> auth (@RequestBody Dipendente dip){ 
		
		return ResponseEntity.ok(auth.authenticate(dip));
		
	}
}
