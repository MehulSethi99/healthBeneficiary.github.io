package com.jpa.exceptions;

public class UserNotFoundException extends RuntimeException{
	private String operation;
	
	public UserNotFoundException(String operation, String message) {
		super(message);
		this.operation=operation;
	}

	public String getOperation() {
		return operation;
	}
}
