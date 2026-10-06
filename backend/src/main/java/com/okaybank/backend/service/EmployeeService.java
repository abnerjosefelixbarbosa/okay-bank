package com.okaybank.backend.service;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto);
}
