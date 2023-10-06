package com.tir.ocinio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Assegnazione;
import com.tir.ocinio.service.AssegnazioneService;

@RestController
@RequestMapping("api/assegnazione")
public class AssegnazioneController {

	@Autowired
	AssegnazioneService assService;
	
	@PostMapping("")
	public ResponseEntity<Assegnazione> inserisciAssegnazione(@RequestBody Assegnazione a){
		a = assService.inserisciAssegnazione(a);
		return  ResponseEntity.ok(a);
	}
	
	@PutMapping("")
	public ResponseEntity<Assegnazione> updateAssegnazione(@RequestBody Assegnazione a){
		a = assService.modificaAssegnazione(a);
		return ResponseEntity.ok(a);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Assegnazione> eliminaAssegnazione(@PathVariable("id") Long id){
		assService.eliminaAssegnazione(id);
		return  ResponseEntity.ok(null);
	}
}
