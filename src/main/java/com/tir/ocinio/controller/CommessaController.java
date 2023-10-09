package com.tir.ocinio.controller;

import java.util.HashMap;
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
public class CommessaController {

	@Autowired
	private CommessaService comService;

	@GetMapping("/{id}")
	public ResponseEntity<Commessa> getCommessaById(@PathVariable(value = "id") Long id) {
		Commessa commessa = comService.getCommessaById(id);
		return new ResponseEntity<>(commessa, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Commessa>> getAllCommesse() {
		List<Commessa> commesse = comService.getAllCommesse();
		return new ResponseEntity<>(commesse, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> getCountCommessa() {
		var counterCommessa = comService.getCountCommessa();
		return new ResponseEntity<>(counterCommessa, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Commessa> insertCommessa(@RequestBody Commessa com) {
		com = comService.insertCommessa(com);
		return new ResponseEntity<>(com, HttpStatus.OK);
	}

}
