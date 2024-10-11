package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.infra.entity.Customer;

@Component
public class CustomerInfraMapper {
	public Customer toCustomer(CreateCustomerDTO dto) {
		Customer customer = new Customer(dto);
		
		return customer;
	}
	
	public Customer toCustomer(LoginCustomerDTO dto) {
		Customer customer = new Customer(dto);
		
		return customer;
	}
	
	public CustomerDTO toCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(customer);
		
		return customerDTO;
	}
}