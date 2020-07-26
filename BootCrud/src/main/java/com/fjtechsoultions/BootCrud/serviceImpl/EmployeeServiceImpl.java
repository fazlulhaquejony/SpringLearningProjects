package com.fjtechsoultions.BootCrud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjtechsoultions.BootCrud.dao.EmplyeeDAO;
import com.fjtechsoultions.BootCrud.entity.Employee;
import com.fjtechsoultions.BootCrud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmplyeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmplyeeDAO theEmployeeDAO)
	{
		employeeDAO = theEmployeeDAO;
		
	}
	
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
	
		employeeDAO.deleteById(theId);

	}

}
