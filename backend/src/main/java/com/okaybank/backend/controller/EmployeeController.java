package com.okaybank.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;
import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;
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

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list")
	public ResponseEntity<Page<EmployeeResponseDTO>> listEmployees(
			@RequestParam(defaultValue = "") EmployeeType employeeType,
			@RequestParam(defaultValue = "") EmployeeStatus employeeStatus, Pageable pageable) {
		Page<EmployeeResponseDTO> response = employeeService.listEmployees(employeeType, employeeStatus, pageable);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
