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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.tir.ocinio.enumeration.Ruolo;
import com.tir.ocinio.service.AuthenticationServiceImpl;
import com.tir.ocinio.service.DipendenteService;




@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private  JwtAuthenticationFilter auth;
	@Autowired
	private  DipendenteService dipService;
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
	    .csrf(AbstractHttpConfigurer::disable)
	    .authorizeHttpRequests(request ->
	        request
	           .requestMatchers("/**").permitAll()
	           //.requestMatchers("/api/dipendente/**").hasAnyAuthority(Ruolo.SENIOR.name())
	           .anyRequest().authenticated()
	    )
	    .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	    .authenticationProvider(authenticationProvider())
	    .addFilterBefore(auth, UsernamePasswordAuthenticationFilter.class);

	return http.build();		
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService( dipService.userDetailsService());
		authenticationProvider.setPasswordEncoder(PasswordEncoder());
		return authenticationProvider;
		
	}
	
	@Bean
	 PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
}
