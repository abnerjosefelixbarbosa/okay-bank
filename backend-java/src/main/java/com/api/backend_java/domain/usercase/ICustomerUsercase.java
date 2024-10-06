package com.api.backend_java.domain.usercase;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;

public interface ICustomerUsercase extends UserDetailsService {
	CustomerDTO create(CreateCustomerDTO dto);
	CustomerDTO login(LoginCustomerDTO dto);
}