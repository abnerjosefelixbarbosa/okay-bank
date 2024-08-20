package com.org.back_end_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.domain.usercase.ICustomerUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping(name = "/customers")
public class CustomerController {
	@Autowired
	private ICustomerUserCase customerUserCase;
	
	@PostMapping(name = "/register")
	public ResponseEntity<String> register(@RequestBody @Valid RegisterCustomerDTO dto) {
		String response = customerUserCase.register(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
