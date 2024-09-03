package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/accounts")
@RestController
@AllArgsConstructor
public class AccountController {
	private IAccountUsercase accountUsercase;
	
	@PostMapping(value = "/create")
	public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO dto) {
		AccountDTO response = accountUsercase.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
