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
		validSaveUpdate(customerModel);
		customerRepository.save(customerModel);
		return "customer saved";
	}

	public String update(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validSaveUpdate(customerModel);
		customerRepository.save(customerModel);
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
	
	public String updateName(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		customerRepository.updateName(customerModel.getName(), customerModel.getId());
		return "customer name updated";
	}
	
	public String updateCpf(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validUpdateCpf(customerModel);
		customerRepository.updateCpf(customerModel.getCpf(), customerModel.getId());
		return "customer cpf updated";
	}
	
	private void validUpdateCpf(CustomerModel customerModel) {
		if (customerRepository.existsByCpf(customerModel.getCpf()))
			throw new EntityBadRequestException("cpf exists");
	}
	
	public String updateRg(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validUpdateRg(customerModel);
		customerRepository.updateRg(customerModel.getRg(), customerModel.getId());
		return "customer rg updated";
	}
	
	private void validUpdateRg(CustomerModel customerModel) {
		if (customerRepository.existsByRg(customerModel.getRg()))
			throw new EntityBadRequestException("rg exists");
	}
	
	public String updatePassword(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validUpdatePassword(customerModel);
		customerRepository.updatePassword(customerModel.getPassword(), customerModel.getId());
		return "customer password updated";
	}
	
	private void validUpdatePassword(CustomerModel customerModel) {
		if (customerRepository.existsByPassword(customerModel.getPassword()))
			throw new EntityBadRequestException("password exists");
	}
	
	public String updateEmail(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validUpdateEmail(customerModel);
		customerRepository.updateEmail(customerModel.getEmail(), customerModel.getId());
		return "customer email updated";
	}
	
	private void validUpdateEmail(CustomerModel customerModel) {
		if (customerRepository.existsByEmail(customerModel.getEmail()))
			throw new EntityBadRequestException("email exists");
	}
	
	public String updateTelephone(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		validUpdateTelephone(customerModel);
		customerRepository.updateTelephone(customerModel.getTelephone(), customerModel.getId());
		return "customer telephone updated";
	}
	
	private void validUpdateTelephone(CustomerModel customerModel) {
		if (customerRepository.existsByTelephone(customerModel.getTelephone()))
			throw new EntityBadRequestException("telephone exists");
	}
	
	public String updateBirthDate(String id, CustomerModel customerModel) {
		CustomerModel findById = findById(id);
		customerModel.setId(findById.getId());
		customerRepository.updateBirthDate(customerModel.getBirthDate(), customerModel.getId());
		return "customer birth date updated";
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
