package com.okaybank.backend.service;

import com.okaybank.backend.dto.CustomerRequestDTO;
import com.okaybank.backend.dto.CustomerResponseDTO;

public interface CustomerService {
	CustomerResponseDTO registerCustomer(CustomerRequestDTO dto);
}
