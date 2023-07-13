package com.org.backend.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.CustomerInterface;
import com.org.backend.models.entities.Customer;
import com.org.backend.models.repositories.CustumerRepository;

@Service
public class CustomerService implements CustomerInterface {
	@Autowired
	private CustumerRepository custumerRepository;

	public Customer loginByCpfAndPassword(String cpf, String password) {
	    var customerModel = custumerRepository.findByCpfAndPassword(cpf, password).orElseThrow(() -> {
			throw new EntityNotFoundException("CPF and password not find");
		});
	    customerModel.setEmployee(null);
        return customerModel;
	}
}
