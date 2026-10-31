package com.okaybank.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okaybank.backend.dto.request.AgencyRequestDTO;
import com.okaybank.backend.dto.response.AgencyResponseDTO;
import com.okaybank.backend.service.AgencyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyController {
	private final AgencyService agencyService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AgencyResponseDTO> registerAgency(@RequestBody @Valid AgencyRequestDTO request) {
		AgencyResponseDTO response = agencyService.registerAgency(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
