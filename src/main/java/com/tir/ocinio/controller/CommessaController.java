package com.tir.ocinio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tir.ocinio.entity.Commessa;
import com.tir.ocinio.repository.dao.CommessaDAO;

@RestController("/v1/commessa")
public class CommessaController {

	@Autowired
	private CommessaDAO commessaDAO;
	
	@GetMapping("/all")
	public ResponseEntity<List<Commessa>> allCommesse(){
		var commesse = commessaDAO.getAll();
		return ResponseEntity.ok(commesse);
		
	}
}
