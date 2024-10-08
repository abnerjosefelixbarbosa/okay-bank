package com.api.backend_java.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.domain.usercase.ICustomerUsercase;

@Component
public class CustomerUsercase implements ICustomerUsercase {
	@Autowired
	private ICustomerGateway customerGateway;

	public CustomerDTO create(CreateCustomerDTO dto) {
		return customerGateway.create(dto);
	}
	
	public CustomerDTO login(LoginCustomerDTO dto) {
		return customerGateway.login(dto);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerGateway.loadUserByUsername(username);
	}
}
