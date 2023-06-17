package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.models.Customer;
import com.org.backend.repositories.CustomerRepository;

@Service
public class CustomerValidation {
	@Autowired
	private CustomerRepository customerRepository;

	public void validateSave(Customer customer) {
		if (customerRepository.existsByCpf(customer.getCpf()))
			throw new EntityBadRequestException("cpf exists");
		if (customerRepository.existsByRg(customer.getRg()))
			throw new EntityBadRequestException("rg exists");
		if (customerRepository.existsByPassword(customer.getPassword()))
			throw new EntityBadRequestException("password exists");
		if (customerRepository.existsByEmail(customer.getEmail()))
			throw new EntityBadRequestException("email exists");
	}
}
