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
		// customerRepository.save(customerModel);
		return "customer saved";
	}

	private void validSave(CustomerModel customerModel) {
		if (customerModel.getName().isEmpty() || customerModel.getName() == null) 
			throw new EntityBadRequestException("name is empty");
		if (customerModel.getName().length() > 100) 
			throw new EntityBadRequestException("name is greater than 100");
		if (!validCpf(customerModel.getCpf())) 
			throw new EntityBadRequestException("cpf is invalid");
		if (customerModel.getRg().isBlank() || customerModel.getRg() == null) 
			throw new EntityBadRequestException("rg is blank");
		if (customerModel.getRg().length() > 20) 
			throw new EntityBadRequestException("rg is greater than 20");
		if (customerModel.getPassword().length() != 6) 
			throw new EntityBadRequestException("password is diferent for 6");
		if (!validEmail(customerModel.getEmail())) 
			throw new EntityBadRequestException("email is invalid");
		if (customerModel.getTelephone().isEmpty() || customerModel.getTelephone() == null) 
			throw new EntityBadRequestException("telephone is empty");
		if (customerModel.getTelephone().length() > 20) 
			throw new EntityBadRequestException("telephone is greater than 20");
		if (customerModel.getBirthDate() == null) 
			throw new EntityBadRequestException("birth date is null");
		if (customerModel.getAddressNumber() == 0 || customerModel.getAddressNumber() == null) 
			throw new EntityBadRequestException("address number is 0");
		if (customerModel.getAddressZipCode().isBlank() || customerModel.getAddressZipCode() == null) 
			throw new EntityBadRequestException("address zip code is blank");
		if (customerModel.getAddressZipCode().length() > 20) 
			throw new EntityBadRequestException("address zip code is greater than 20");
		if (customerModel.getAddressName().isEmpty() || customerModel.getAddressName() == null) 
			throw new EntityBadRequestException("address name is empty");
		if (customerModel.getAddressName().length() > 50) 
			throw new EntityBadRequestException("address name is greater than 50");
		if (customerModel.getAddressNeighborhood().isEmpty() || customerModel.getAddressNeighborhood() == null) 
			throw new EntityBadRequestException("address neighborhood is empty");
		if (customerModel.getAddressNeighborhood().length() > 30) 
			throw new EntityBadRequestException("address neighborhood is greater than 30");
		if (customerModel.getAddressCity().isEmpty() || customerModel.getAddressCity() == null) 
			throw new EntityBadRequestException("address city is empty");
		if (customerModel.getAddressCity().length() > 30) 
			throw new EntityBadRequestException("address city is greater than 30");
		if (customerModel.getAddressState().isBlank() || customerModel.getAddressState() == null) 
			throw new EntityBadRequestException("address state is blank");
		if (customerModel.getAddressState().length() > 2) 
			throw new EntityBadRequestException("address state is greater than 2");
		if (customerRepository.existsByCpf(customerModel.getCpf())) 
			throw new EntityBadRequestException("Cpf exists");
		if (customerRepository.existsByRg(customerModel.getRg())) 
			throw new EntityBadRequestException("Rg exists");
		if (customerRepository.existsByPassword(customerModel.getPassword())) 
			throw new EntityBadRequestException("Password exists");
		if (customerRepository.existsByEmail(customerModel.getEmail())) 
			throw new EntityBadRequestException("Email exists");
		if (customerRepository.existsByTelephone(customerModel.getTelephone())) 
			throw new EntityBadRequestException("Telephone exists");
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
