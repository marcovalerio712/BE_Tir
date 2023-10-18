package com.tir.ocinio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tir.ocinio.enumeration.Anzianita;
import com.tir.ocinio.filters.JwtAuthenticationFilter;
import com.tir.ocinio.service.DipendenteService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//non estende ne implementa alcuna classe o interfaccia
	
	//necessaria dependy injection del filtro per autenticare richiesta
	@Autowired
	private JwtAuthenticationFilter auth; 
	
	@Autowired
	private DipendenteService dipService;
	
	//
	@Bean
	SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		//Cross Site Request Forgery -- attacco hacker che manda una richiesta con tutti 
		//i dati, che però sta accedendo per conto di un altro pc e quindi disabilitandola evitiamo questo
		http.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests( request -> 
			request				
				.requestMatchers("api/auth/**").permitAll() //permettiamo tutte le richieste con tale path url
				.requestMatchers("/api/**").hasAnyAuthority(Anzianita.HR.nome)
				.requestMatchers("/api/task/**").hasAnyAuthority(Anzianita.SENIOR.nome)
				.anyRequest().authenticated())
		.sessionManagement(manager -> 
			manager
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authProvider())
			.addFilterBefore(auth, UsernamePasswordAuthenticationFilter.class);
		return http.build();		
	}
	
	@Bean
	AuthenticationProvider authProvider () {
		var authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(dipService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
		
	}
	
	@Bean
	AuthenticationManager authManager (AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	

}
