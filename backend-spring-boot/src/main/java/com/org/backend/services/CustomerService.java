package com.org.backend.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.CustomerMethods;
import com.org.backend.models.CustomerModel;
import com.org.backend.repositories.CustomerRepository;

@Service
public class CustomerService implements CustomerMethods {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerModel> findAll() {
		return customerRepository.findByOrderByName();
	}
	
	public CustomerModel findById(UUID id) {
		return customerRepository.findById(id).orElseThrow(() -> {
			return new EntityNotFoundException("id not found");
		});
	}

	public String save(CustomerModel customerModel) {
		validSaveUpdate(customerModel);
		customerModel.setId(null);
		customerRepository.save(customerModel);
		return "customer saved";
	}
	
	public String update(UUID id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validSaveUpdate(customerModel);
		//customerRepository.save(customerModel);
		return "customer updated";
	}

	private void validSaveUpdate(CustomerModel customerModel) {
		if (customerRepository.existsByCpf(customerModel.getCpf())) 
			throw new EntityBadRequestException("cpf exists");
		if (customerRepository.existsByRg(customerModel.getRg())) 
			throw new EntityBadRequestException("rg exists");
		if (customerRepository.existsByPassword(customerModel.getPassword())) 
			throw new EntityBadRequestException("password exists");
		if (customerRepository.existsByEmail(customerModel.getEmail())) 
			throw new EntityBadRequestException("email exists");
		if (customerRepository.existsByTelephone(customerModel.getTelephone())) 
			throw new EntityBadRequestException("telephone exists");
	}
}
