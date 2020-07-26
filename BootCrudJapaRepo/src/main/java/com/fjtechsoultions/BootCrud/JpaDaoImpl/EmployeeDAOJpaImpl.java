package com.fjtechsoultions.BootCrud.JpaDaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fjtechsoultions.BootCrud.dao.EmployeeDAO;
import com.fjtechsoultions.BootCrud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		//create query
		Query theQuery =entityManager.createQuery("from Employee");
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}
	
	

	@Override
	public Employee findById(int theId) {
		
		//get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//return
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee dbEmployee =entityManager.merge(theEmployee);
		
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
