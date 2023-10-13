	package com.tir.ocinio.service;

import java.security.Key;
import java.sql.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JWTService {

	
    
    public String generateToken(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    
    public String generateRefreshToken(Map <String,Object> extractClaims ,UserDetails user) {
        return Jwts.builder()
        		.setClaims(extractClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(0))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSiginKey() {
    	byte[] key = Decoders.BASE64.decode("413F4428472B4B6250655368566D5970337336763979244226452948404D6351");
    	return Keys.hmacShaKeyFor(key);
    }
    
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaim(token);
        return claimsResolver.apply(claims); 
    }

    private Claims extractAllClaim(String token) {
    	  return Jwts.parserBuilder().setSigningKey(getSiginKey()).build().parseClaimsJws(token).getBody();
    }
    
    public String extractUsername(String token) {
    	return extractClaim(token, Claims::getSubject);
    }
    
    public boolean isTokenValid(String token, UserDetails user) {
    	final String username = extractUsername(token);
    	return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

	private boolean isTokenExpired(String token) {
		return extractClaim(token, Claims::getExpiration).before(new Date(0));
	}



    
}


