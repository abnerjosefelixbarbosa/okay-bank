package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.EnterAccountDTO;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/accounts")
@RestController
@AllArgsConstructor
public class AccountController {
	private final IAccountUsercase accountUsercase;
	
	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a account")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "create account"),
			@ApiResponse(responseCode = "400", description = "invalid account data"),
			@ApiResponse(responseCode = "404", description = "not found account data") 
	})
	public ResponseEntity<AccountDTO> create(@Valid @RequestBody CreateAccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountUsercase.create(dto));
	}
	
	@PostMapping(value = "/enter")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "enter a account")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "return account"),
			@ApiResponse(responseCode = "400", description = "invalid account data"),
			@ApiResponse(responseCode = "404", description = "not found account data") 
	})
	public ResponseEntity<AccountDTO> enterByAccountAndAgency(@Valid @RequestBody EnterAccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
