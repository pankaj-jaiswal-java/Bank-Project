package com.nit.pankaj.exceptions;

public class NotInitializedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotInitializedException(){
		
	}

	public NotInitializedException(String msg) {
		super(msg);
	}
}
