package com.tir.ocinio.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

	String extractUsername(String token);
	
	String generateToken(UserDetails user);
	
	String generateRefreshToken(Map <String,Object> extractClaims, UserDetails user);
	
	boolean isTokenValid(String token, UserDetails user);


}
