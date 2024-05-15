package com.jpa.exceptions;

public class BeneficiaryNotFoundException extends RuntimeException{
	
	private String operation;
	
	public BeneficiaryNotFoundException(String operation, String message) {
		super(message);
		this.operation=operation;
	}
	public String getOperation() {
		return operation;
	}

}
