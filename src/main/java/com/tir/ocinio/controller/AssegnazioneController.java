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

@RestController
@RequestMapping("api/assegnazione")
public class AssegnazioneController extends Controller{

	@Autowired
	AssegnazioneService assService;
	
	
	public AssegnazioneController() {
		this.format = "{id, dipendente:{id}, commessa:{id}, competenza, attivo}";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> getAssegnazioneById(@PathVariable("id") Long id){
		var ass = assService.getAsssegnazioneById(id);			
		var assMap = serializer.serialize(format, ass);
		return ResponseEntity.ok(assMap);
	}
	
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> inserisciAssegnazione(@RequestBody Assegnazione a){
		a = assService.inserisciAssegnazione(a);
		var assMap = serializer.serialize(format, a);
		return  ResponseEntity.ok(assMap);
	}
	
	@PutMapping("")
	public ResponseEntity<HashMap<String, Object>> updateAssegnazione(@RequestBody Assegnazione a){
		a = assService.modificaAssegnazione(a);
		var assMap = serializer.serialize(format, a);
		return ResponseEntity.ok(assMap);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Assegnazione> eliminaAssegnazione(@PathVariable("id") Long id){
		assService.eliminaAssegnazione(id);
		return  ResponseEntity.ok(null);
	}
}
