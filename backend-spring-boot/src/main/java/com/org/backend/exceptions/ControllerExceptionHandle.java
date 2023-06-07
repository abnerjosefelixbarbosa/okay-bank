package com.org.backend.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandle {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HandleError> entityBadRequest(Exception e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(EntityBadRequestException.class)
	public ResponseEntity<HandleError> entityBadRequest(EntityBadRequestException e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<HandleError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Not found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
