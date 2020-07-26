package com.fjtechsolutions.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.fjtechsolutions.dao.*;
import com.fjtechsolutions.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//inject the session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {


		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		return customers;
		
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomers(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object using primary key
         Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
         theQuery.setParameter("customerId", theId);
		
         //execute query
         theQuery.executeUpdate();
		
		
	}
	
	

}
