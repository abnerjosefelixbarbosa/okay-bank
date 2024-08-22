package com.org.back_end_java.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.back_end_java.adapter.ICustomerGateway;
import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.domain.usercase.ICustomerUserCase;

@Component
public class CustomerUserCase implements ICustomerUserCase {
	@Autowired
	private ICustomerGateway customerGateway;

	public String register(RegisterCustomerDTO dto) {
		return customerGateway.register(dto);
	}
}
