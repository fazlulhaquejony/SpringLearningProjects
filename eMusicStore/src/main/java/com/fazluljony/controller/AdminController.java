package com.fazluljony.controller;

 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fazluljony.model.Product;
import com.fazluljony.service.ProductService;

import java.io.File;
import java.nio.file.*;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	

	@RequestMapping("/admin")
    public String adminShow()
    {
   	 return "admin";
    }
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model)
	{
		List<Product> product = productService.getProductList();
		model.addAttribute("product",product);
		
		return "productInventory";
	}
	
	@RequestMapping("/admin/productInventory/productAdd")
	public String productAdd(Model model)
	{
		Product product = new Product();
		model.addAttribute("product", product);
		return "productAdd";
	}
	
	@PostMapping("/admin/productInventory/productAdd")
	public String addProductpost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request ) {
		
		if(result.hasErrors())
		{
			return "productAdd";
		}
		
		productService.addProduct(product);
		 
		 MultipartFile productImage = product.getProductImage();
		 
		 //String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get("F:\\JavaEE Project\\eMusicStore\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		 
		 if(productImage!=null && !productImage.isEmpty())
		 {
			 try {
				 productImage.transferTo(new File(path.toString()));
			 }
			 catch(Exception e)
			 {
				 throw new RuntimeException("Product Image saving failed",e );
			 }
		 }
		 
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/{id}")
	public String deleteProduct(@PathVariable("id") String id , Model model, HttpServletRequest request ) {
		
		Path path = Paths.get("F:\\JavaEE Project\\eMusicStore\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+id+".png");
		
		if(Files.exists(path))
		{
			try {
				Files.delete(path);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
		int Id = Integer.parseInt(id);
		productService.delete(Id);
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/productEdit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		
		int Id = Integer.parseInt(id);
		Product product = productService.getProductById(Id);
		model.addAttribute(product);
		return "productEdit";
		
	}
	
	
	
	@PostMapping("/admin/productInventory/productEdit")
	public String editProductpost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request ) {
		
		if(result.hasErrors())
		{
			return "productEdit";
		}
		
		productService.addProduct(product);
		 
		 MultipartFile productImage = product.getProductImage();
		 
		 //String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get("F:\\JavaEE Project\\eMusicStore\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		 
		 if(productImage!=null && !productImage.isEmpty())
		 {
			 try {
				 productImage.transferTo(new File(path.toString()));
			 }
			 catch(Exception e)
			 {
				 throw new RuntimeException("Product Image sediting failed",e );
			 }
		 }
		 
		return "redirect:/admin/productInventory";
	}
	


}
