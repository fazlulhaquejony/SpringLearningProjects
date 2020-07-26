package com.fjtechsolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fjtechsolutions.dao.CustomerDAO;
import com.fjtechsolutions.entity.Customer;
import com.fjtechsolutions.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	 
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model themodel)
	{
		//get customer from DAO
		List<Customer> theCustomers = customerService.getCustomers(); 
		
		// add the customers to the model
		themodel.addAttribute("customers" , theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer" , theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCostomer)
	{
		customerService.saveCustomer(theCostomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		//get customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set attribute to the model
		theModel.addAttribute("customer" , theCustomer);
		
		
		return "customer-form";
		
	}
	
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	
	
	
	
	 

}
