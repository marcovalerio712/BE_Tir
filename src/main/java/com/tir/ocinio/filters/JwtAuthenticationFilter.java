package com.tir.ocinio.filters;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.tir.ocinio.service.DipendenteService;
import com.tir.ocinio.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;

	@Autowired
	private DipendenteService dipService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String jwt = (String) request.getSession().getAttribute("jwt");
		if (jwt != null && !jwt.isEmpty()) {
			String email = jwtService.extractUsername(jwt);

			if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = dipService.loadUserByUsername(email);

				if (jwtService.isTokenValid(jwt, user)) {
					SecurityContext secCon = SecurityContextHolder.createEmptyContext();
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null,
							user.getAuthorities());
					token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					secCon.setAuthentication(token);
					SecurityContextHolder.setContext(secCon);
				}
			}

		}

		filterChain.doFilter(request, response);
	}
}
