package com.fazlul.jackson.json;


import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper= new ObjectMapper();
			//read JSON file and  map/convert to Java POJO
			
			//data/sample-lite.json
			Student theStudent =mapper.readValue(
					new File("data/sample-lite.json"), Student.class);
			//print first and last name
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("First Name: " + theStudent.getLastName());
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}

	}

}
