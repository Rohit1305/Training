package com.aurionpro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class StudentExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException (StudentNotFoundException e){
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException (MethodArgumentTypeMismatchException e){
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("inavlid Student Id was passed");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException (Exception e){
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("inavlid Request : " + e.getLocalizedMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
