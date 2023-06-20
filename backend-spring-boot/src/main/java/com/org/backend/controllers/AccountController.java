package com.org.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.interfaces.AccountInterface;
import com.org.backend.models.Account;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
	@Autowired
	private AccountInterface accountInterface;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/find-all-by-id/{id}", produces = MediaType.APPLICATION_GRAPHQL_RESPONSE_VALUE)
	public ResponseEntity<List<Account>> findAllById(@PathVariable String id) {
		var accounts = accountInterface.findAllByAccount(id);
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
}
