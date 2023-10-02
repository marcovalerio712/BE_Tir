package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tir.ocinio.entity.Dipendente;
import com.tir.ocinio.repository.mapper.DipendenteRowMapper;

@Repository
public class DipendenteDAO implements DAO<Dipendente>{

	@Autowired 
	private JdbcTemplate template;
	
	@Override
	public Dipendente getById(Long id) {
		
		
		String query = "select d.id dip_id, d.nome dip_nome, d.cognome dip_cognome, "
				+ "	d.cf dip_cf, d.email dip_email, d.password dip_password, d.telefono dip_telefono, "
				+ "	d.registrato dip_registrato, d.attivo dip_attivo, r.id ruo_id, r.anzianita ruo_anzianita, "
				+ "						r.compenso ruo_compenso "
				+ "						from Dipendenti d, Ruoli r "
				+ "						where d.id_ruolo = r.id(+) and d.id = " + id;
		
		var dipendente = template.queryForObject(query, new DipendenteRowMapper());
		
		return dipendente;
	}

	@Override
	public List<Dipendente> getAll() {
		
		String query = "select d.id dip_id, d.nome dip_nome, d.cognome dip_cognome, "
				+ "	d.cf dip_cf, d.email dip_email, d.password dip_password, d.telefono dip_telefono, "
				+ "	d.registrato dip_registrato, d.attivo dip_attivo, r.id ruo_id, r.anzianita ruo_anzianita, "
				+ "						r.compenso ruo_compenso "
				+ "						from Dipendenti d, Ruoli r "
				+ "						where d.id_ruolo = r.id(+)";
		
		var dipendenti = template.query(query, new DipendenteRowMapper());
		return dipendenti;
	}

	@Override
	public int count() {
		String query = "select count(*) from dipendenti";
		var counter = template.queryForObject(query, Integer.class);
		return counter;
	}

	
	
	
}
