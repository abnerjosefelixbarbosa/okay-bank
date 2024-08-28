package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/accounts")
@RestController
@AllArgsConstructor
public class AccountController {

	@PostMapping(value = "/create")
	public ResponseEntity<AccountView> create(@Valid @RequestBody AccountDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
