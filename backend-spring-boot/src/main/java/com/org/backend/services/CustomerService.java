package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.CustomerMethods;
import com.org.backend.models.CustomerModel;
import com.org.backend.repositories.CustomerRepository;

@Service
public class CustomerService implements CustomerMethods {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerValidation customerValidation;

	public List<CustomerModel> findAll() {
		return customerRepository.findByOrderByName();
	}

	public CustomerModel findById(String id) {
		return customerRepository.findById(id).orElseThrow(() -> {
			return new EntityNotFoundException("id not found");
		});
	}

	public String save(CustomerModel customerModel) {
		customerModel.setId(null);
		customerValidation.validateSave(customerModel);
		customerRepository.save(customerModel);
		return "customer saved";
	}
}
