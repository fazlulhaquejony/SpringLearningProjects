package com.fazluljony.service;

import java.io.IOException;
import java.util.List;

import com.fazluljony.model.Product;

public interface ProductService {
	
	public List<Product>getProductList();

	public Product getProductById(int ProductId);
	
	public void addProduct(Product product);
	
	public void delete(int theId);
	
	void editProduct(Product product);


}
