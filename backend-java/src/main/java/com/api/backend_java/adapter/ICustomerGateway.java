package com.api.backend_java.adapter;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.infra.entity.Customer;

public interface ICustomerGateway extends UserDetailsService {
	CustomerDTO create(CreateCustomerDTO dto);
	Customer getById(String id);
	CustomerDTO login(LoginCustomerDTO dto);
}
