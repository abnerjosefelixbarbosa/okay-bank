package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.interfaces.CustomerMethods;
import com.org.backend.models.CustomerModel;
import com.org.backend.repositories.CustomerRepository;

import br.com.caelum.stella.validation.CPFValidator;
import jakarta.mail.internet.InternetAddress;

@Service
public class CustomerService implements CustomerMethods {
	@Autowired
    private CustomerRepository customerRepository;
	
	public String save(CustomerModel customerModel) {
		validSave(customerModel);
		customerRepository.save(customerModel);
		return "customer saved";
	}
	
	private void validSave(CustomerModel customerModel) {
		if (customerModel.getName().isEmpty()) { 
			throw new EntityBadRequestException("Name is empty");
		}
		if (customerModel.getName().equals(null)) { 
			throw new EntityBadRequestException("Name is null");
		}
		if (customerModel.getName().length() > 100) { 
			throw new EntityBadRequestException("Name is greater than 100");
		}
		if (customerRepository.existsByCpf(customerModel.getCpf())) {
			throw new EntityBadRequestException("Cpf exists");
		}
		if (!validCpf(customerModel.getCpf())) {
			throw new EntityBadRequestException("Cpf is invalid");
		}
		if (customerRepository.existsByRg(customerModel.getRg())) {
			throw new EntityBadRequestException("Rg exists");
		}
		if (customerModel.getRg().length() > 20) {
			throw new EntityBadRequestException("Rg is invalid");
		}
		if (customerRepository.existsByPassword(customerModel.getPassword())) {
			throw new EntityBadRequestException("Password exists");
		}
		if (customerModel.getPassword().length() != 6) {
			throw new EntityBadRequestException("Password is invalid");
		}
		if (customerRepository.existsByEmail(customerModel.getEmail())) {
			throw new EntityBadRequestException("Email exists");
		}
		if (!validEmail(customerModel.getEmail())) {
			throw new EntityBadRequestException("Email is invalid");
		}
		if (customerRepository.existsByTelephone(customerModel.getTelephone())) {
			throw new EntityBadRequestException("Telephone exists");
		}
		if (customerModel.getTelephone().length() > 20) {
			throw new EntityBadRequestException("Telephone is greater than 20");
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
	
	private boolean validEmail(String email) {
		try {
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
