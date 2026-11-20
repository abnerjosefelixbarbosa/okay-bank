package com.okay_bank.backend.infra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okay_bank.backend.application.entity.Agency;
import com.okay_bank.backend.application.usercase.AgencyUserCase;
import com.okay_bank.backend.infra.dto.request.AgencyRequestDTO;
import com.okay_bank.backend.infra.dto.response.AgencyResponseDTO;
import com.okay_bank.backend.infra.mapper.AgencyMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/agencies")
public class AgencyContoller {
	private final AgencyUserCase agencyUserCase;
	
	public AgencyContoller(AgencyUserCase agencyUserCase) {
		this.agencyUserCase = agencyUserCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AgencyResponseDTO> registerAgency(@RequestBody @Valid AgencyRequestDTO resquest) {
		Agency agency = AgencyMapper.toAgency(resquest);
		
		agency = agencyUserCase.registerAgency(agency);
		
		AgencyResponseDTO response = AgencyMapper.toAgencyResponseDTO(agency); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
