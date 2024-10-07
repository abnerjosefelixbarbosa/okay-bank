package com.api.backend_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RequestMapping(value = "/accounts")
@RestController
public class AccountController {
	@Autowired
	private IAccountUsercase accountUsercase;
	
	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a account")
	public ResponseEntity<AccountDTO> create(@Valid @RequestBody CreateAccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountUsercase.create(dto));
	}
	
	@PostMapping(value = "/enter")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "enter a account")
	public ResponseEntity<AccountDTO> enterByAccountAndAgency(@Valid @RequestBody EnterAccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountUsercase.enter(dto));
	}
	
	@PutMapping(value = "/transfer")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "transfer balance a account")
	public ResponseEntity<AccountDTO> transfer(@RequestParam String idAccount1, @RequestParam String idAccount2, @Valid @RequestBody TransferAccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountUsercase.tranfer(dto));
	}
}
