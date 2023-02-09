package com.capgemini.lenskart.exception;

public class ProductsNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ProductsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}