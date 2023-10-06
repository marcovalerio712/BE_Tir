package com.tir.ocinio.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Assegnazione;
import com.tir.ocinio.service.AssegnazioneService;
import com.tir.ocinio.util.JsonSerializer;

@RestController
@RequestMapping("api/assegnazione")
public class AssegnazioneController {

	@Autowired
	AssegnazioneService assService;
	
	JsonSerializer serializer = new JsonSerializer();
	
	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> getAssegnazione(@PathVariable("id") Long id){
		var ass = assService.getAsssegnazioneById(id);
		
		String format = "{id, dipendente:{id}, commessa:{id}, competenza, attivo}";
				
		var assMap = serializer.serialize(format, ass);
		
		return ResponseEntity.ok(assMap);
	}
	
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
