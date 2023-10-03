package com.tir.ocinio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.service.DipendenteService;

@RestController
@RequestMapping("api/dipendente")
public class DipendenteController {

	@Autowired
	private DipendenteService dipService;
	
	@GetMapping("")
	public List<Dipendente> getAllDipendenti(){
		return dipService.getAllDipendenti();
	}
	
	
}
