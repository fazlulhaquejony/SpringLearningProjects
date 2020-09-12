package com.fazluljony.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fazluljony.dao.Productdao;
import com.fazluljony.model.Product;
import com.fazluljony.service.ProductService;

@Service
public class ProductserviceImpl implements ProductService {

	@Autowired
	private Productdao productdao;
	
	public ProductserviceImpl() {
		//default constructor
	}


	@Override
	@Transactional
	public List<Product> getProductList() {
		return productdao.getProductList();
	}

	@Override
	@Transactional
	public Product getProductById(int productId) {
		return productdao.getProductById(productId);
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		 productdao.addProduct(product);
		
	}


	@Override
	@Transactional
	public void delete(int theId) {
		productdao.delete(theId);
		
	}


	@Override
	@Transactional
	public void editProduct(Product product) {
		productdao.editProduct(product);
		
	}
  
	

}
