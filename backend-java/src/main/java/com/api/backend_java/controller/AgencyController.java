package com.api.backend_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import jakarta.validation.Valid;

@RequestMapping(value = "/agencies")
@RestController
public class AgencyController {
	@Autowired
	private IAgencyUsercase agencyUsercase;

	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "create a agency")
	public ResponseEntity<AgencyDTO> create(@RequestBody @Valid CreateAgencyDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(agencyUsercase.create(dto));
	}
}
