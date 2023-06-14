package com.org.backend.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.TelephoneDto;
import com.org.backend.interfaces.TelephoneMethods;
import com.org.backend.models.TelephoneModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/telephones")
public class TelephoneController {
	@Autowired
	private TelephoneMethods telephoneMethods;
	
	@Operation(description = "find all telephones")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-all")
	public ResponseEntity<List<TelephoneModel>> findAll() {
		var customerModels = telephoneMethods.findAll();
		return ResponseEntity.status(200).body(customerModels);
	}

	@Operation(description = "find telephone by id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<TelephoneModel> findById(@PathVariable String id) {
		var telephoneModel = telephoneMethods.findById(id);
		return ResponseEntity.status(200).body(telephoneModel);
	}

	@Operation(description = "save telephone")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "400", description = "Bad request") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody TelephoneDto telephoneDto) {
		telephoneDto.validateSave();
		var customerModel = new TelephoneModel();
		BeanUtils.copyProperties(telephoneDto, customerModel);
		var message = telephoneMethods.save(customerModel);
		return ResponseEntity.status(201).body(message);
	}	
}
