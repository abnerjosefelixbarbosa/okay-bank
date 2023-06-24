package com.org.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.CustomerLoginByCpfAndPasswordDto;
import com.org.backend.interfaces.CustomerInterface;
import com.org.backend.models.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	@Autowired
	private CustomerInterface customerInterface;

	@Operation(description = "login by cpf and password")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/login-by-cpf-and-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> loginByCpfAndPassword(@RequestBody @Valid CustomerLoginByCpfAndPasswordDto dto) {
		var customer = customerInterface.findByCpfAndPassword(dto.getCpf(), dto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
}
