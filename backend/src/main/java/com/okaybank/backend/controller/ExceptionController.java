package com.okaybank.backend.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.okaybank.backend.dto.response.ExceptionResponseDTO;
import com.okaybank.backend.exception.ApplicationException;
import com.okaybank.backend.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
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
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ExceptionResponseDTO> handleApplicationException(ApplicationException e, HttpServletRequest request) {
		ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), 400, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(400).body(response);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
		ExceptionResponseDTO response = new ExceptionResponseDTO(LocalDateTime.now(), 400, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(400).body(response);
	}
}
