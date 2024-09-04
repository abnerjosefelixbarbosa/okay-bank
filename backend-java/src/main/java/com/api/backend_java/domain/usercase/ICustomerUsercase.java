package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.CustomerDTO;

public interface ICustomerUsercase {
	CustomerDTO create(CustomerDTO dto);
}