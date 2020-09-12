package com.fazluljony.daoImpl;

import java.io.IOException;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fazluljony.dao.Productdao;
import com.fazluljony.model.Product;

@Repository
public class ProductdaoImpl implements Productdao {

	@Autowired 
	private SessionFactory sessionFactory;
	


	@Override
	public List<Product> getProductList() {
		Session currentsession = sessionFactory.getCurrentSession();
		
		Query<Product> thequery = currentsession.createQuery("from Product", Product.class);
		
		List<Product> Products = thequery.getResultList(); 
		
		return Products;
	}

	@Override
	public Product getProductById(int ProductId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Product product =(Product)currentSession.get(Product.class, ProductId);
		
		return product;
	}
	

	@Override
	public void addProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
	}



	@Override
	public void delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Product where id =: productId");
		query.setParameter("productId", theId);
		
		query.executeUpdate();
		
	}



	@Override
	public void editProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
		
	}

}
