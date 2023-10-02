package com.tir.ocinio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.dao.DAO;

@SpringBootTest
class BeApplicationTests {

	@Autowired 
	private DAO<Dipendente> dao;
	
	@Test
	void contextLoads() {
		
		var federico = dao.getById(1L);
		
		System.out.println(federico);
		
	}

}
