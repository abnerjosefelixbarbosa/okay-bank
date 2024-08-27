package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;
import com.api.backend_java.domain.usercase.IAgencyUserCase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping(value = "/agencies")
@RestController
@AllArgsConstructor
public class AgencyController {
	private IAgencyUserCase agencyUserCase;
	
	@PostMapping(value = "/create")
	public ResponseEntity<AgencyView> create(@RequestBody @Valid AgencyDTO dto) {
		AgencyView agencyView = agencyUserCase.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(agencyView);
	}
}
