package com.capgemini.lenskart.exception;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}