package com.org.backend.controllers;

import java.util.List;

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
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-all")
	public ResponseEntity<List<CustomerModel>> findAll() {
		List<CustomerModel> customerModels = customerMethods.findAll();
		return ResponseEntity.status(200).body(customerModels);
	}

	@Operation(description = "find customer by id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<CustomerModel> findById(@PathVariable String id) {
		CustomerModel customerModel = customerMethods.findById(id);
		return ResponseEntity.status(200).body(customerModel);
	}

	@Operation(description = "save customer")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "400", description = "Bad request") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CustomerDto customerDto) {
		customerDto.validateSave();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.save(customerModel);
		return ResponseEntity.status(201).body(message);
	}
	
	@Operation(description = "update customer name")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update-name/{id}")
	public ResponseEntity<String> updateName(@PathVariable String id,
			@RequestBody CustomerDto customerDto) {
		customerDto.validateUpdateName();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.updateName(id, customerModel);
		return ResponseEntity.status(200).body(message);
	}
	
	@Operation(description = "update customer telephone")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update-telephone/{id}")
	public ResponseEntity<String> updateTelephone(@PathVariable String id,
			@RequestBody CustomerDto customerDto) {
		customerDto.validateUpdateTelephone();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.updateTelephone(id, customerModel);
		return ResponseEntity.status(200).body(message);
	}
	
	@Operation(description = "update customer email")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update-email/{id}")
	public ResponseEntity<String> updateEmail(@PathVariable String id,
			@RequestBody CustomerDto customerDto) {
		customerDto.validateUpdateEmail();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.updateEmail(id, customerModel);
		return ResponseEntity.status(200).body(message);
	}

	@Operation(description = "update customer address")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update-address/{id}")
	public ResponseEntity<String> updateAddress(@PathVariable String id,
			@RequestBody CustomerDto customerDto) {
		customerDto.validateUpdateAddress();
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDto, customerModel);
		String message = customerMethods.updateAddress(id, customerModel);
		return ResponseEntity.status(200).body(message);
	}
}
