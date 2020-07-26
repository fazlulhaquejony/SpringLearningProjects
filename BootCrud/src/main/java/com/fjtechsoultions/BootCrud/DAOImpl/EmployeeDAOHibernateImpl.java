package com.fjtechsoultions.BootCrud.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fjtechsoultions.BootCrud.dao.EmplyeeDAO;
import com.fjtechsoultions.BootCrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmplyeeDAO {

	//define field for entitymanager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
		
	}
	
	@Override
	//@Transactional   
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee>theQuery = currentSession.createQuery("from Employee" , Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get current  hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get Current Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save session
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
	     
		theQuery.executeUpdate();
	}

}
