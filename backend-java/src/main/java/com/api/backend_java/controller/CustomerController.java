package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginDTO;
import com.api.backend_java.domain.usercase.ICustomerUsercase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/customers")
@RestController
@AllArgsConstructor
public class CustomerController {
	private ICustomerUsercase customerUsercase;
	
	@PostMapping(value = "/create")
	public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerUsercase.create(dto));
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<CustomerDTO> login(@RequestBody @Valid LoginDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(customerUsercase.login(dto));
	}
}
