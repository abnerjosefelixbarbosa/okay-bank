package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.models.CustomerModel;
import com.org.backend.repositories.CustomerRepository;

@Service
public class CustomerValidation {
	@Autowired
	private CustomerRepository customerRepository;
	
	public void validateSave(CustomerModel customerModel) {
		if (customerRepository.existsByCpf(customerModel.getCpf()))
			throw new EntityBadRequestException("cpf exists");
		if (customerRepository.existsByRg(customerModel.getRg()))
			throw new EntityBadRequestException("rg exists");
		if (customerRepository.existsByPassword(customerModel.getPassword()))
			throw new EntityBadRequestException("password exists");
		if (customerRepository.existsByEmail(customerModel.getEmail()))
			throw new EntityBadRequestException("email exists");
		//if (customerRepository.existsByTelephone(customerModel.getTelephone()))
			//throw new EntityBadRequestException("telephone exists");
	}
}
