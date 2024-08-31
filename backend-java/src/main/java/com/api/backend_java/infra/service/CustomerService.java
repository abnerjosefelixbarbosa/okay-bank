package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.ICustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerGateway {
	private ICustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public boolean existsByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact,
			String password) {
		return customerRepository.existsByCpfOrRgOrEmailOrContactOrPassword(cpf, rg, email, contact, password);
	}
}
