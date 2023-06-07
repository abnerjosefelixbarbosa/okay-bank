package com.org.backend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.CustomerDto;
import com.org.backend.interfaces.CustomerMethods;
import com.org.backend.models.CustomerModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerMethods customerMethods;
	
	@Operation(description = "save")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Created"),
		@ApiResponse(responseCode = "400", description = "Bad request")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid CustomerDto customerDto) {	
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.save(customerModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
}
