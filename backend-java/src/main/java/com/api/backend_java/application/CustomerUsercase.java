package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.usercase.ICustomerUsercase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomerUsercase implements ICustomerUsercase {
	private ICustomerGateway customerGateway;

	public CustomerDTO create(CustomerDTO dto) {
		return customerGateway.create(dto);
	}
}
