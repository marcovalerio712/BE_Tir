package com.tir.ocinio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.service.DipendenteService;

@RestController
@RequestMapping("api/dipendente")
public class DipendenteController {

	@Autowired
	private DipendenteService dipService;
	
	@GetMapping("/all")
	public List<Dipendente> getAllDipendenti() {
		return dipService.getAllDipendenti();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dipendente> getDipendente(@PathVariable("id") Long id) {
		var dip = dipService.getDipendenteById(id);
		return ResponseEntity.ok(dip);
	}
	
	@PostMapping("")
	public ResponseEntity<Dipendente> registerDipendente(@RequestBody Dipendente dip){
		dip = dipService.registerDipendente(dip);
		return ResponseEntity.ok(dip);
	}
	
	@PutMapping("")
	public ResponseEntity<Dipendente> updateDipendente(@RequestBody Dipendente dip) {
		dip = dipService.updateDipendente(dip);
		return ResponseEntity.ok(dip);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDipendente(@PathVariable("id") Long id) {
		dipService.deleteDipendente(id);
		return ResponseEntity.ok(null);
	}
	
}
