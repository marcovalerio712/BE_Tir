package com.tir.ocinio.repository.dao;

import java.util.List;

public interface DAO<T> {

	public T getById(Long id);
	
	public List<T> getAll();
	
	public int count();
	
}
