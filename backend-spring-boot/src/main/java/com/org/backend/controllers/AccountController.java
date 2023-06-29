package com.org.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.AccountFindByAgencyAndAccountDto;
import com.org.backend.dtos.AccountTransferBalanceDto;
import com.org.backend.interfaces.AccountInterface;
import com.org.backend.models.Account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

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
	public ResponseEntity<List<Account>> listAllById(@PathVariable String id) {
		var accountModels = accountInterface.listAllByAccount(id);	
		return ResponseEntity.status(HttpStatus.OK).body(accountModels);
	}
	
	@PostMapping(path = "/find-by-agency-and-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findByAgencyAndAccount(@RequestBody @Valid AccountFindByAgencyAndAccountDto dto) {
		var agency = dto.getAgency();
		var account = dto.getAccount();
		var accountModel = accountInterface.findByAgencyAndAccount(agency, account);
		return ResponseEntity.status(HttpStatus.OK).body(accountModel);
	}
	
	@PutMapping(path = "/transfer-balance/{id1}/{id2}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> transferBalance(@PathVariable String id1, @PathVariable String id2, @RequestBody @Valid AccountTransferBalanceDto dto) {
		var balance = dto.getBalance();
		dto.validation();
		var message = accountInterface.transferBalance(id1, id2, balance);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
}
