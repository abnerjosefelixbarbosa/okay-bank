package com.org.apibancookay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.apibancookay.interfaces.CustomerMethod;
import com.org.apibancookay.models.Customer;
import com.org.apibancookay.repositories.CustomerRepository;

@Service
public class CustomerService implements CustomerMethod {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer findByCpfAndPassword(Customer customer) {
		return customerRepository.findByCpfAndPassword(customer.getCpf(), customer.getPassword()).orElse(null);
	}
}
