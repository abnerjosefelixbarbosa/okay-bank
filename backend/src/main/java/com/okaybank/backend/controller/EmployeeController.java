package com.okaybank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;
import com.okaybank.backend.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public ResponseEntity<EmployeeResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRequestDTO dto) {
		EmployeeResponseDTO response = employeeService.registerEmployee(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
