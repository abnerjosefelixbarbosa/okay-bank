package com.okaybank.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;
import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);

	Page<EmployeeResponseDTO> listEmployees(EmployeeType employeeType, EmployeeStatus employeeStatus,
			Pageable pageable);
}
