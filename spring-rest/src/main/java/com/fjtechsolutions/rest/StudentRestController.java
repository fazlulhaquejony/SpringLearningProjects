package com.fjtechsolutions.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjtechsolutions.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData()
	{
        theStudents = new ArrayList<>();
		
		theStudents.add(new Student("h. m.","fazlul"));
		theStudents.add(new Student("fariha","arifin"));
		theStudents.add(new Student("fazlul","fariha"));
		
	}
	
	
	
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		
		return theStudents;
	}
	
	
	//define endpointfor "/students/{studentId}" -returnstudent at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		//just index into the list .. keep simple for now
		
		//check the studentId against list size
		
		if((studentId >= theStudents.size() || (studentId <0) ))
		{
			throw new StudentNotFoundException("Student id not found -" + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	//Add an exception handler using @Exception Handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
	{
		//create a studentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exc.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		//return Repository
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	
	//add another exception Handler  .. to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(Exception exc){
		
		//create a studentErrorResponse
		
				StudentErrorResponse error = new StudentErrorResponse();
				
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				 error.setMessage(exc.getMessage());
				 error.setTimeStamp(System.currentTimeMillis());
				//return Repository
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	
	
}
