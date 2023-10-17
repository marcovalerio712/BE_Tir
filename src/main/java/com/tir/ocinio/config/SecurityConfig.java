package com.tir.ocinio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tir.ocinio.enumeration.Ruolo;
import com.tir.ocinio.service.DipendenteService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//non estende ne implementa alcuna classe o interfaccia
	
	//necessaria dependy injection del filtro per autenticare richiesta
	@Autowired
	private JwtAuthenticationFilter auth; 
	
	@Autowired
	private DipendenteService dipendente;
	
	//
	@Bean
	SecurityFilterChain filterChain (HttpSecurity http){
		//Cross Site Request Forgery -- attacco hacker che manda una richiesta con tutti 
		//i dati, che però sta accedendo per conto di un altro pc e quindi disabilitandola evitiamo questo
		http.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests( request -> 
			request				
				.requestMatchers("api/auth/**").permitAll() //permettiamo tutte le richieste con tale path url
				.requestMatchers("/api/**").hasAnyAuthority(Ruolo.HR.nome)
				.requestMatchers("/api/task/**").hasAnyAuthority(Ruolo.SENIOR.nome)
				.anyRequest().authenticated())
		.sessionManagement(manager -> 
			manager
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
			.authenticationProvider(authenticationProvider())
			.addFilterBefore(auth, UsernamePasswordAuthenticationFilter.class);
		return http.build();		
	}
	
	
	
	
	

}
