package com.org.backend.controllers.controllers;

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

import com.org.backend.models.dtos.AccountDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountDto;
import com.org.backend.models.dtos.AccountTransferBalanceDto;
import com.org.backend.models.interfaces.AccountMethods;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
	@Autowired
	private AccountMethods accountMethods;
	
	@Operation(description = "get by id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "404", description = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/get-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> getById(@PathVariable(required = false) String id) {
		var responseDto = accountMethods.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	@Operation(description = "get all by customer id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "404", description = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/get-all-by-customer-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountDto>> getAllByCustomerId(@PathVariable(required = false) String id) {
		var accountDtos = accountMethods.getAllByCustomerId(id);	
		return ResponseEntity.status(HttpStatus.OK).body(accountDtos);
	}
	
	@Operation(description = "find by agency and account")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad request"),
		@ApiResponse(responseCode = "404", description = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "/find-by-agency-and-account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> findByAgencyAndAccount(@RequestBody @Valid AccountFindByAgencyAndAccountDto requestDto) {
		var responseDto = accountMethods.findByAgencyAndAccount(requestDto);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	@Operation(description = "transfer balance")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad request"),
		@ApiResponse(responseCode = "404", description = "Not found")
	})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path = "/transfer-balance/{id1}/{id2}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> transferBalance(@PathVariable(required = false) String id1, @PathVariable(required = false) String id2, @RequestBody @Valid AccountTransferBalanceDto requestDto) {
		requestDto.validation();
		var responseDto = accountMethods.transferBalance(id1, id2, requestDto);
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
}
