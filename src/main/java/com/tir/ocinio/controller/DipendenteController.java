package com.tir.ocinio.controller;

import java.util.HashMap;
import java.util.List;
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

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.service.DipendenteService;

@RestController
@RequestMapping("api/dipendente")
public class DipendenteController extends Controller{

	@Autowired
	private DipendenteService dipService;
	
	public DipendenteController() {
		this.format = "{id,nome,cognome,cf,email,telefono,ruolo:{id},registrato,attivo}";
	}
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> getAllDipendenti() {
		var all = dipService.getAllDipendenti();
		var allMap = serializer.serialize(format, all);
		return ResponseEntity.ok(allMap);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> getDipendente(@PathVariable("id") Long id) {
		var dip = dipService.getDipendenteById(id);
		var getMap = serializer.serialize(format, dip);
		return ResponseEntity.ok(getMap);
	}
	
	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> registerDipendente(@RequestBody Dipendente dip){
		dip = dipService.registerDipendente(dip);
		var regMap = serializer.serialize(format, dip);
		return ResponseEntity.ok(regMap);
	}
	
	@PutMapping("")
	public ResponseEntity<HashMap<String, Object>> updateDipendente(@RequestBody Dipendente dip) {
		dip = dipService.updateDipendente(dip);
		var upMap = serializer.serialize(format, dip);
		return ResponseEntity.ok(upMap);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDipendente(@PathVariable("id") Long id) {
		dipService.deleteDipendente(id);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/confirm/{token}")
	public ResponseEntity<Object> confirmRegistration(@PathVariable("token") String token){
		dipService.confirmRegistration(token);
		return ResponseEntity.ok(null);
	}
	
}
