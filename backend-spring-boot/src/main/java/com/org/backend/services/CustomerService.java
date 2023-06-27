package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.CustomerInterface;
import com.org.backend.models.Customer;
import com.org.backend.repositories.CustumerRepository;

@Service
public class CustomerService implements CustomerInterface {
	@Autowired
	private CustumerRepository custumerRepository;

	public Customer loginByCpfAndPassword(String cpf, String password) {
	    var customer = custumerRepository.findByCpfAndPassword(cpf, password).orElseThrow(() -> {
			return new EntityNotFoundException("CPF and password not find");
		});
		customer.setEmployee(null);
        return customer;
	}
}
