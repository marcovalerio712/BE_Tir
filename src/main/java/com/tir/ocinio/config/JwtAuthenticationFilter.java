package com.tir.ocinio.config;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.tir.ocinio.service.AuthenticationServiceImpl;
import com.tir.ocinio.service.DipendenteService;
import com.tir.ocinio.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private  JWTService jwtService;
	@Autowired
	private  DipendenteService dipService;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String email;
		if(org.apache.commons.lang.StringUtils.isEmpty(authHeader) || !org.apache.commons.lang.StringUtils.startsWith(authHeader, "Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);
		email = jwtService.extractUsername(jwt);
		if(org.apache.commons.lang.StringUtils.isNotEmpty(email) && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails user =  dipService.userDetailsService().loadUserByUsername(email);
			if (jwtService.isTokenValid(jwt, user)) {
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				securityContext.setAuthentication(token);
				SecurityContextHolder.setContext(securityContext);
			}
		}
		filterChain.doFilter(request, response);
	}

}
