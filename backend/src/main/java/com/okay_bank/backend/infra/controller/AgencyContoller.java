package com.okay_bank.backend.infra.controller;

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

import com.okay_bank.backend.application.entity.Agency;
import com.okay_bank.backend.application.usercase.AgencyUserCase;
import com.okay_bank.backend.infra.dto.request.AgencyRequestDTO;
import com.okay_bank.backend.infra.dto.response.AgencyResponseDTO;
import com.okay_bank.backend.infra.mapper.AgencyMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/agencies")
public class AgencyContoller {
	private final AgencyUserCase agencyUserCase;
	
	public AgencyContoller(AgencyUserCase agencyUserCase) {
		this.agencyUserCase = agencyUserCase;
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "registra uma agência"),
			@ApiResponse(responseCode = "400", description = "retorna um erro de requesição")
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "registrar agência", description = "registra uma agência")
	public ResponseEntity<AgencyResponseDTO> registerAgency(@RequestBody @Valid AgencyRequestDTO resquest) {
		Agency agency = AgencyMapper.toAgency(resquest);
		
		agency = agencyUserCase.registerAgency(agency);
		
		AgencyResponseDTO response = AgencyMapper.toAgencyResponseDTO(agency); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AgencyResponseDTO> updateAgency(@PathVariable String id, @RequestBody @Valid AgencyRequestDTO resquest) {
		Agency agency = AgencyMapper.toAgency(resquest);
		
		agency = agencyUserCase.updateAgency(id, agency);
		
		AgencyResponseDTO response = AgencyMapper.toAgencyResponseDTO(agency); 
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AgencyResponseDTO> findAgencyById(@PathVariable String id) {		
		Agency agency = agencyUserCase.findAgencyById(id);
		
		AgencyResponseDTO response = AgencyMapper.toAgencyResponseDTO(agency); 
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
