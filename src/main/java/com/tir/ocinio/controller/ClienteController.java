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


import com.tir.ocinio.entity.Cliente;
import com.tir.ocinio.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService cliService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long id){
		Cliente cliente = cliService.getClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClienti(){
		List<Cliente> clienti = cliService.getAllClienti();
		return new ResponseEntity<>(clienti, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Integer> getCountClienti(){
		var counterClienti = cliService.getCountClienti();
		return new ResponseEntity<>(counterClienti, HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cli){
		cli = cliService.insertCliente(cli);
		return new ResponseEntity<>(cli, HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cli){
		cli = cliService.updateCliente(cli);
		return new ResponseEntity<>(cli, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id){
		cliService.deleteCliente(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
