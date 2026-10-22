package com.okaybank.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okaybank.backend.dto.CustomerRequestDTO;
import com.okaybank.backend.dto.CustomerResponseDTO;
import com.okaybank.backend.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public ResponseEntity<CustomerResponseDTO> registerCustomer(@RequestBody @Valid CustomerRequestDTO dto) {
		CustomerResponseDTO response = customerService.registerCustomer(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
