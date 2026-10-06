package com.okaybank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.dto.AgencyResponseDTO;
import com.okaybank.backend.service.AgencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
	@Autowired
	private AgencyService agencySevice;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public ResponseEntity<AgencyResponseDTO> registerAgency(@RequestBody @Valid AgencyRequestDTO dto) {
		AgencyResponseDTO response = agencySevice.registerAgency(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public ResponseEntity<AgencyResponseDTO> updateAgency(@PathVariable String id, @RequestBody @Valid AgencyRequestDTO dto) {
		AgencyResponseDTO response = agencySevice.updateAgency(id, dto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
