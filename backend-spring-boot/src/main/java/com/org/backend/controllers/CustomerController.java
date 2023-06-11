package com.org.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerMethods customerMethods;
	
	@Operation(description = "find all customer")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-all")
	public ResponseEntity<List<CustomerModel>> findAll() {	
		List<CustomerModel> customerModels = customerMethods.findAll();
		return ResponseEntity.status(200).body(customerModels);
	}
	
	@Operation(description = "find customer by id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "400", description = "Bad request")
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<CustomerModel> findById(@PathVariable UUID id) {	
		CustomerModel customerModel = customerMethods.findById(id);
		return ResponseEntity.status(200).body(customerModel);
	}
	
	@Operation(description = "save customer")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Created"),
		@ApiResponse(responseCode = "400", description = "Bad request")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CustomerDto customerDto) {	
		customerDto.validation();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.save(customerModel);
		return ResponseEntity.status(201).body(message);
	}
	
	@Operation(description = "update customer")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad request")
	})
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {	
		customerDto.validation();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.update(id, customerModel);
		return ResponseEntity.status(200).body(message);
	}
}
