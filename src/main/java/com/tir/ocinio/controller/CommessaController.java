package com.tir.ocinio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.service.CommessaService;

@RestController
@RequestMapping("/api/commessa")
public class CommessaController extends Controller{
	
	@Autowired
	private CommessaService comService;
	
	public CommessaController() {
		format = "{id, tipo, durata, descrizione, importContratto, dataInizio, dataFine, cliente:{id}, attivo}";
	}

	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> getCommessaById(@PathVariable(value = "id") Long id) {
		Commessa commessa = comService.getCommessaById(id);
		var commessaMap = serializer.serialize(format, commessa);
		return new ResponseEntity<>(commessaMap, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<HashMap<String, Object>>> getAllCommesse() {
		List<Commessa> commesse = comService.getAllCommesse();
		var commessaList = serializer.serializeAll(format, commesse);
		return new ResponseEntity<>(commessaList, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> getCountCommessa() {
		var counterCommessa = comService.getCountCommessa();
		return new ResponseEntity<>(counterCommessa, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<HashMap<String, Object>> insertCommessa(@RequestBody Commessa com) {
		com = comService.insertCommessa(com);
		var comMap = serializer.serialize(format, com);
		return new ResponseEntity<>(comMap, HttpStatus.OK);
	}

}
