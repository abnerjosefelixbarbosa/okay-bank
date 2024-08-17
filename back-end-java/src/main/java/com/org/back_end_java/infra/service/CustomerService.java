package com.org.back_end_java.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.back_end_java.infra.entity.Customer;
import com.org.back_end_java.infra.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;
	
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Customer customer  = customerRepository.findByCpf(cpf)
				.orElseThrow(() -> new UsernameNotFoundException("customer not found"));
		return customer;
	}
}
