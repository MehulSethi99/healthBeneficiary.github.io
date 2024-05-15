package com.jpa.exceptions;

public class HealthPackageNotFoundException extends RuntimeException{
	
	private String operation;
	public HealthPackageNotFoundException(String operation,String message) {
		super(message);
		this.operation=operation;
	}
	public String getOperation() {
		return operation;
	}
}
