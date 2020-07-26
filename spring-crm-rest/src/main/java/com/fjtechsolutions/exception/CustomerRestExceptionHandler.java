package com.fjtechsolutions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add an exception Handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc)
	{
	
		//create Customer Error Response
		
		CustomerErrorResponse error = new CustomerErrorResponse(
				                            HttpStatus.NOT_FOUND.value(),
				                            exc.getMessage(),
				                            System.currentTimeMillis());
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	
	}
	//Add another handler .. to catch any exception

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc)
	{
	
		//create Customer Error Response
		
		CustomerErrorResponse error = new CustomerErrorResponse(
				                            HttpStatus.BAD_REQUEST.value(),
				                            exc.getMessage(),
				                            System.currentTimeMillis());
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	
	}

}
