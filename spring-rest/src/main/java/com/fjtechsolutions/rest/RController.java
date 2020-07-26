package com.fjtechsolutions.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World!";
	}
}
