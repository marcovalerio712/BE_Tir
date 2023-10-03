package com.tir.ocinio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Cliente;
import com.tir.ocinio.entity.Consuntivo;
import com.tir.ocinio.service.ConsuntivoService;
import com.tir.ocinio.service.DipendenteService;

@RestController
@RequestMapping("api/consuntivo")
public class ConsuntivoController {
	
	@Autowired
	private ConsuntivoService conService;
	
	@Autowired
	private DipendenteService dipService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Consuntivo> getConsuntivoById(@PathVariable(value = "id") Long id) {
		Consuntivo consuntivo = conService.getConsuntivoById(id);
		return new ResponseEntity<>(consuntivo, HttpStatus.OK);		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Consuntivo>> getAllConsuntivi(){
		List<Consuntivo> consuntivi = conService.getAllConsuntivi();
		return new ResponseEntity<>(consuntivi, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Integer> getCountConsuntivi(){
		var counterConsuntivi = conService.getCountConsuntivi();
		return new ResponseEntity<>(counterConsuntivi, HttpStatus.OK);
	}	

}