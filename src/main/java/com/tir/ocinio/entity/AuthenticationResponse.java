package com.tir.ocinio.entity;

public class AuthenticationResponse {

	private String token;
	
	private String refreshToken;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
