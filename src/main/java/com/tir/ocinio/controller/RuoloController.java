package com.tir.ocinio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tir.ocinio.entity.Ruolo;
import com.tir.ocinio.service.RuoloService;

@RestController
@RequestMapping("api/ruolo")
public class RuoloController {
	
	@Autowired
	private RuoloService ruoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Ruolo> getRuoloById(@PathVariable(value = "id") Long id) {
		
		Ruolo ruolo = ruoService.getRuoloById(id);
		
		return new ResponseEntity<>(ruolo, HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Ruolo>> getAllRuoli(){
		List<Ruolo> ruoli = ruoService.getAllRuoli();
		return new ResponseEntity<>(ruoli, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Ruolo> insertRuolo(@RequestBody Ruolo ruo){
		
		ruo = ruoService.insertRuolo(ruo);
		
		return new ResponseEntity<>(ruo, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Ruolo> updateRuolo(@RequestBody Ruolo ruo) {
		
		ruo = ruoService.updateRuolo(ruo);
		
		return new ResponseEntity<>(ruo, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRuolo(@RequestParam (value = "id") Long id) {
		
		ruoService.deleteRuolo(id);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
		
	}
}
