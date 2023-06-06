package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.interfaces.CustomerMethods;
import com.org.backend.models.Customer;
import com.org.backend.repositories.CustomerRepository;

import br.com.caelum.stella.validation.CPFValidator;

@Service
public class CustomerService implements CustomerMethods {
	@Autowired
    private CustomerRepository customerRepository;
	
	public String save(Customer customer) {
		validSave(customer);
		//customerRepository.save(customer);
		return "customer saved";
	}
	
	private void validSave(Customer customer) {
		if (customer.getName().isEmpty()) { 
			throw new EntityBadRequestException("Name empty");
		}
		if (!validCpf(customer.getCpf())) {
			throw new EntityBadRequestException("CPF invalid");
		}
	}
	
	private boolean validCpf(String cpf) {
		try {
			CPFValidator cpfValidator = new CPFValidator();
			String newCpf = cpf.replace(".", "").replace("-", "");
			cpfValidator.assertValid(newCpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
