package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.domain.usercase.IAgencyUsercase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/agencies")
@RestController
@AllArgsConstructor
public class AgencyController {
	private final IAgencyUsercase agencyUsercase;
	
	@PostMapping(value = "/create")
	public ResponseEntity<AgencyDTO> create(@RequestBody @Valid CreateAgencyDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(agencyUsercase.create(dto));
	}
}
