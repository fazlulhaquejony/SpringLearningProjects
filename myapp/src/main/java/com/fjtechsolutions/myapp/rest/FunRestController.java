package com.fjtechsolutions.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Coach" + coachName +", Team name" + teamName;
	}
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Its Jony ! Time on server is " + LocalDateTime.now();
	}

}
