package com.fjtechsolutions.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		
	}

	public CustomerNotFoundException(String arg0) {
		super(arg0);
		
	}

	public CustomerNotFoundException(Throwable arg0) {
		super(arg0);
			}

	public CustomerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public CustomerNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
			}

}
