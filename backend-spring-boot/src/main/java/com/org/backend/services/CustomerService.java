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
		if (customerModel.getName() == null) { 
			throw new EntityBadRequestException("Name is null");
		}
		if (customerModel.getName().isEmpty()) { 
			throw new EntityBadRequestException("Name is empty");
		}
		if (customerModel.getName().length() > 100) { 
			throw new EntityBadRequestException("Name is greater than 100");
		}
		if (!validCpf(customerModel.getCpf())) {
			throw new EntityBadRequestException("Cpf is invalid");
		}
		if (customerRepository.existsByCpf(customerModel.getCpf())) {
			throw new EntityBadRequestException("Cpf exists");
		}
		if (customerModel.getRg() == null) {
			throw new EntityBadRequestException("Rg is null");
		}
		if (customerModel.getRg().isEmpty()) {
			throw new EntityBadRequestException("Rg is empty");
		}
		if (customerModel.getRg().length() > 20) {
			throw new EntityBadRequestException("Rg is greater than 20");
		}
		if (customerRepository.existsByRg(customerModel.getRg())) {
			throw new EntityBadRequestException("Rg exists");
		}
		if (customerModel.getPassword().length() != 6) {
			throw new EntityBadRequestException("Password is diferent for 6");
		}
		if (customerRepository.existsByPassword(customerModel.getPassword())) {
			throw new EntityBadRequestException("Password exists");
		}
		if (!validEmail(customerModel.getEmail())) {
			throw new EntityBadRequestException("Email is invalid");
		}
		if (customerRepository.existsByEmail(customerModel.getEmail())) {
			throw new EntityBadRequestException("Email exists");
		}
		if (customerModel.getTelephone() == null) {
			throw new EntityBadRequestException("Telephone is null");
		}
		if (customerModel.getTelephone().isEmpty()) {
			throw new EntityBadRequestException("Telephone is empty");
		}
		if (customerModel.getTelephone().length() > 20) {
			throw new EntityBadRequestException("Telephone is greater than 20");
		}
		if (customerRepository.existsByTelephone(customerModel.getTelephone())) {
			throw new EntityBadRequestException("Telephone exists");
		}
		if (customerModel.getBirthDate() == null) {
			throw new EntityBadRequestException("Birth date is null");
		}
		if (customerModel.getAddressNumber() == null) {
			throw new EntityBadRequestException("Address number is null");
		}
		if (customerModel.getAddressNumber() == 0) {
			throw new EntityBadRequestException("Address number is 0");
		}
		if (customerModel.getAddressZipCode() == null) {
			throw new EntityBadRequestException("Address zip code is null");
		}
		if (customerModel.getAddressZipCode().isEmpty()) {
			throw new EntityBadRequestException("Address zip code is empty");
		}
		if (customerModel.getAddressZipCode().length() > 20) {
			throw new EntityBadRequestException("Address zip code is greater than 20");
		}
		if (customerModel.getAddressName() == null) {
			throw new EntityBadRequestException("Address name is null");
		}
		if (customerModel.getAddressName().isEmpty()) {
			throw new EntityBadRequestException("Address name is empty");
		}
		if (customerModel.getAddressName().length() > 50) {
			throw new EntityBadRequestException("Address name is greater than 50");
		}
		if (customerModel.getAddressNeighborhood() == null) {
			throw new EntityBadRequestException("Address neighborhood is null");
		}
		if (customerModel.getAddressNeighborhood().isEmpty()) {
			throw new EntityBadRequestException("Address neighborhood is empty");
		}
		if (customerModel.getAddressNeighborhood().length() > 30) {
			throw new EntityBadRequestException("Address neighborhood is greater than 30");
		}
		if (customerModel.getAddressCity() == null) {
			throw new EntityBadRequestException("Address city is null");
		}
		if (customerModel.getAddressCity().isEmpty()) {
			throw new EntityBadRequestException("Address city is empty");
		}
		if (customerModel.getAddressCity().length() > 30) {
			throw new EntityBadRequestException("Address city is greater than 30");
		}
		if (customerModel.getAddressState() == null) {
			throw new EntityBadRequestException("Address state is null");
		}
		if (customerModel.getAddressState().isEmpty()) {
			throw new EntityBadRequestException("Address state is empty");
		}
		if (customerModel.getAddressState().length() > 2) {
			throw new EntityBadRequestException("Address state is greater than 2");
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
