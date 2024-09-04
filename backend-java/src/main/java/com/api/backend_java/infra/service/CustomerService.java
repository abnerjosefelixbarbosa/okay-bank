package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.ICustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerGateway {
	private ICustomerRepository customerRepository;

	public boolean existsByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact,
			String password) {
		return customerRepository.existsByCpfOrRgOrEmailOrContactOrPassword(cpf, rg, email, contact, password);
	}

	public CustomerDTO create(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validade(Customer customer) {
		
	}
}
