package com.org.back_end_java.controller;

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

import com.org.back_end_java.domain.dto.ExceptionView;

import jakarta.persistence.EntityNotFoundException;
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
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionView> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ExceptionView exceptionView = new ExceptionView();
		exceptionView.setLocalDateTime(LocalDateTime.now());
		exceptionView.setStatus(400);
		exceptionView.setMessage(e.getMessage());
		exceptionView.setPath(request.getRequestURI());
		return ResponseEntity.status(400).body(exceptionView);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionView> handleNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
		ExceptionView exceptionView = new ExceptionView();
		exceptionView.setLocalDateTime(LocalDateTime.now());
		exceptionView.setStatus(404);
		exceptionView.setMessage(e.getMessage());
		exceptionView.setPath(request.getRequestURI());
		return ResponseEntity.status(404).body(exceptionView);
	}
}