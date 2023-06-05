package com.org.apibancookay.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.apibancookay.dtos.AccountDTO;
import com.org.apibancookay.dtos.CustomerDTO;
import com.org.apibancookay.interfaces.AccountMethod;
import com.org.apibancookay.models.Account;
import com.org.apibancookay.models.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountMethod accountMethod;

	//949.612.154-30
	//481228
	//
	//370.897.974-57
	//583245
	@Operation(description = "login by cpf and password")
	@ApiResponses({
		    @ApiResponse(responseCode = "200", description = "ok"),
			@ApiResponse(responseCode = "400", description = "bad request"),
			@ApiResponse(responseCode = "404", description = "not found") 
    })
	@PostMapping("/login-by-cpf-and-password")
	public ResponseEntity<?> loginByCpfAndPassword(@RequestBody CustomerDTO customerDTO) {
		try {
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDTO, customer);

			Account accountLogged = accountMethod.loginByCpfAndPassword(customer);
			if (accountLogged == null) {
				return ResponseEntity.status(404).body("conta não encontrada");
			}

			return ResponseEntity.status(200).body(accountLogged);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	//1568-1
	//13681-1
	//
	//2210-1
	//21224-1
	@Operation(description = "find by agency and account")
	@ApiResponses({ 
		    @ApiResponse(responseCode = "200", description = "ok"),
			@ApiResponse(responseCode = "400", description = "bad request"),
			@ApiResponse(responseCode = "404", description = "not found")
	})
	@PostMapping("/find-by-agency-and-account")
	public ResponseEntity<?> findByAgencyAndAccount(@RequestBody AccountDTO accountDTO) {
		try {
			Account account = new Account();
			BeanUtils.copyProperties(accountDTO, account);

			Account accountFound = accountMethod.findByAgencyAndAccount(account);
			if (accountFound == null) {
				return ResponseEntity.status(404).body("conta não encontrada");
			}

			return ResponseEntity.status(200).body(accountFound);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@Operation(description = "transfer balance")
	@ApiResponses({ 
		@ApiResponse(responseCode = "200", description = "ok"),
		@ApiResponse(responseCode = "400", description = "bad request"),
		@ApiResponse(responseCode = "404", description = "not found") 
	})
	@PutMapping("/transfer-balance/{id1}/{id2}")
	public ResponseEntity<?> transferBalance(@PathVariable Long id1, @PathVariable Long id2,
			@RequestBody AccountDTO accountDTO) {
		try {
			Account account = new Account();
			BeanUtils.copyProperties(accountDTO, account);

			String balanceTransferred = accountMethod.transferBalance(id1, id2, account);
			if (balanceTransferred.equals("conta 1 não encontrada")) {
				return ResponseEntity.status(404).body(balanceTransferred);
			}
			
			if (balanceTransferred.equals("conta 2 não encontrada")) {
				return ResponseEntity.status(404).body(balanceTransferred);
			}

			return ResponseEntity.status(200).body(balanceTransferred);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}
}
