package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.domain.usercase.ICustomerUsercase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/customers")
@RestController
@AllArgsConstructor
public class CustomerController {
	private final ICustomerUsercase customerUsercase;
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a customer")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "create customer"),
			@ApiResponse(responseCode = "400", description = "invalid customer data"),
			@ApiResponse(responseCode = "404", description = "not found customer data") 
	})
	public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CreateCustomerDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerUsercase.create(dto));
	}
	
	@PostMapping(value = "/login")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "login a customer")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "return customer"),
			@ApiResponse(responseCode = "400", description = "invalid customer data"),
			@ApiResponse(responseCode = "404", description = "not found customer data") 
	})
	public ResponseEntity<CustomerDTO> login(@RequestBody @Valid LoginCustomerDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(customerUsercase.login(dto));
	}
}
