package com.tir.ocinio.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tir.ocinio.entity.Task;
import com.tir.ocinio.repository.mapper.TaskRowMapper;
import com.tir.ocinio.repository.query.TaskQuery;

@Repository
public class TaskDAO implements DAO<Task> {
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public Task getById(Long id) {
		String query = String.format(TaskQuery.oneTask, id);
		var task = template.queryForObject(query, new TaskRowMapper());
		return task;
	}

	@Override
	public List<Task> getAll() {
		String query = TaskQuery.allTask;
		var task = template.query(query, new TaskRowMapper());
		return task;
	}

	@Override
	public int count() {
		String query = TaskQuery.countTask;
		var counter = template.queryForObject(query, Integer.class);
		return counter;
	
	}

	@Override
	public Task insert(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task update(Task t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
