package com.fjtechsolutions.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	//add exception handling code here
	
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
