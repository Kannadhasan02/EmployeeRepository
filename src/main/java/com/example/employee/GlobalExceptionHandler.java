package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFoundExceptionHandling(NameNotFoundException n){
		return new  ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= AgeException.class)
	public ResponseEntity<Object> ageExceptionHandling(AgeException ae){
		return new ResponseEntity<> (ae.getMessage(),HttpStatus.NOT_FOUND);
	}

}
