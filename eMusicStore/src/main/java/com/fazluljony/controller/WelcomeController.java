package com.fazluljony.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fazluljony.model.Product;
import com.fazluljony.service.ProductService;

@Controller
public class WelcomeController {

	@Autowired
	private ProductService productservice;
	
	@RequestMapping("/")
     public String IndexShow()
     {
    	 return "index";
     }
	
	@RequestMapping("/productlist")
	public String getProduct(Model model)
	{
		List<Product> product = productservice.getProductList();
		model.addAttribute("products", product);
		
		return "productlist";
	}
	
	@RequestMapping("/productlist/productview/{productId}")
	public String viewproduct(@PathVariable String productId, Model model ) throws IOException
	{
		int Id = Integer.parseInt(productId);
		Product product = productservice.getProductById(Id);
	    model.addAttribute(product);
	
		return "productview";
	}
	
	

}
