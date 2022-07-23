package com.electricity_demo.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerException {
	
	@ExceptionHandler(value = IdDoesNotExistException.class)
	public ResponseEntity<?> userExists(IdDoesNotExistException idDoesNotExistException) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Customer Id does not exists..");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
	

	@ExceptionHandler(value = EmailDoesNotExistException.class)
	public ResponseEntity<?> emailExists(EmailDoesNotExistException emailDoesNotExistException) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Email does not exists..");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = AadharNoNotFoundException.class)
	public ResponseEntity<?> aadharExists(AadharNoNotFoundException aadharNoNotFoundException) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Aadhar number does not exists..");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	
	

	

}
