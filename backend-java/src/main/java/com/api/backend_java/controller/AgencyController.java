package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.domain.usercase.IAgencyUsercase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/agencies")
@RestController
@AllArgsConstructor
public class AgencyController {
	private final IAgencyUsercase agencyUsercase;

	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a agency")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "create agency"),
			@ApiResponse(responseCode = "400", description = "invalid agency data"),
			@ApiResponse(responseCode = "404", description = "not found agency data") 
	})
	public ResponseEntity<AgencyDTO> create(@RequestBody @Valid CreateAgencyDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(agencyUsercase.create(dto));
	}
}
