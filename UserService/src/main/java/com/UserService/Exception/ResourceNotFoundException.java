package com.UserService.Exception;


public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource Not Found In The System");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

	

	
	

}
