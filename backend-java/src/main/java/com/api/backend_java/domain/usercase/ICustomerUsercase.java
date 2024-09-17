package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;

public interface ICustomerUsercase {
	CustomerDTO create(CreateCustomerDTO dto);
	CustomerDTO login(LoginCustomerDTO dto);
}