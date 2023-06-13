package com.org.backend.services;

import java.util.List;

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

	public CustomerModel findById(String id) {
		return customerRepository.findById(id).orElseThrow(() -> {
			return new EntityNotFoundException("id not found");
		});
	}

	public String save(CustomerModel customerModel) {
		customerModel.setId(null);
		validSave(customerModel);
		customerRepository.save(customerModel);
		return "customer saved";
	}
	
	private void validSave(CustomerModel customerModel) {
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
	
	public String updateName(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		customerRepository.updateName(customerModel.getName(), customerModel.getId());
		return "customer name updated";
	}

	public String updateAddress(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		customerRepository.updateAddress(customerModel.getAddressNumber(), customerModel.getAddressZipCode(),
				customerModel.getAddressName(), customerModel.getAddressNeighborhood(), customerModel.getAddressCity(),
				customerModel.getAddressState(), customerModel.getId());
		return "customer address updated";
	}
}
