package com.UserService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UserService.Beans.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	//using this annotation spring knows when this method needs to execute.
	//it get executed whenever ResourceNotFoundException occur in the whole project
	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(new ApiResponse("From Controller Advice: "+ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
}
