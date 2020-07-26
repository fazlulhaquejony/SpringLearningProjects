package com.fjtechsoultions.BootCrud.dao;

import java.util.List;

import com.fjtechsoultions.BootCrud.entity.Employee;

public interface EmplyeeDAO {

	public List<Employee> findAll(); 
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
