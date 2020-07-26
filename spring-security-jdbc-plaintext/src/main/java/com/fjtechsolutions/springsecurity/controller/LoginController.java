package com.fjtechsolutions.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage()
	{
		return "fancy-login";
	}
	
	//add request mapping for /acess-denied
	@GetMapping("/access-denied")
	public String showAccessDenied()
	{
		return "access-denied";
	}
	
	
}
