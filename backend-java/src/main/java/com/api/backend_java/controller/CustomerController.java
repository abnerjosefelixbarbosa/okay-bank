package com.api.backend_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.domain.dto.TokenDTO;
import com.api.backend_java.domain.usercase.ICustomerUsercase;
import com.api.backend_java.domain.usercase.ITokenUsercase;
import com.api.backend_java.infra.entity.Customer;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RequestMapping(value = "/customers")
@RestController
public class CustomerController {
	@Autowired
	private ICustomerUsercase customerUsercase;
	@Autowired
	private ITokenUsercase tokenUsercase;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a customer")
	public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CreateCustomerDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerUsercase.create(dto));
	}
	
	@PostMapping(value = "/login")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "login a customer")
	public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginCustomerDTO dto) {
		UsernamePasswordAuthenticationToken  user = new UsernamePasswordAuthenticationToken(dto.getCpf(), dto.getPassword());
		Authentication auth = authenticationManager.authenticate(user);
		Customer customer = (Customer) customerUsercase.loadUserByUsername(dto.getCpf());
		String token = tokenUsercase.generateToken((Customer) auth.getPrincipal());
		TokenDTO tokenDTO = new TokenDTO();
		tokenDTO.setCpf(customer.getCpf());
		tokenDTO.setPassword(customer.getPassword());
		tokenDTO.setToken(token);
		
		return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
	}
}
