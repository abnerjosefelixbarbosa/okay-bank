package com.org.backend.controllers;

import java.util.LinkedList;
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

import com.org.backend.dtos.AccountDto;
import com.org.backend.interfaces.AccountInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
	@Autowired
	private AccountInterface accountInterface;
	
	@Operation(description = "list all by id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "404", description = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/list-all-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountDto>> listAllById(@PathVariable String id) {
		var accounts = accountInterface.findAllByAccount(id);
		var accountDtos = new LinkedList<AccountDto>();
		var accountDto = new AccountDto();
		accounts.stream().forEach((val) -> {
			accountDto.setListAllById(val);
			accountDtos.add(accountDto);
		});		
		return ResponseEntity.status(HttpStatus.OK).body(accountDtos);
	}
}
