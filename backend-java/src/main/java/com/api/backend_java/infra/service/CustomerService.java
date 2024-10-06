package com.api.backend_java.infra.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.exception.NotFoundException;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.mapper.CustomerInfraMapper;
import com.api.backend_java.infra.repository.ICustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService implements ICustomerGateway {
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private CustomerInfraMapper customerMapper;

	@Transactional
	public CustomerDTO create(CreateCustomerDTO dto) {
		Customer customer = customerMapper.toCustomer(dto);
		validade(customer);
		customer.setPassword(crypt().encode(customer.getPassword()));
		customer = customerRepository.save(customer);
		
		return customerMapper.toCustomerDTO(customer);
	}

	public CustomerDTO login(LoginCustomerDTO dto) {
		return customerRepository
				.findByCpfAndPassword(dto.getCpf(), dto.getPassword())
				.map(customerMapper::toCustomerDTO)
				.orElseThrow(() -> new NotFoundException("customer not found"));
	}

	public Customer getById(String id) {
		return customerRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("customer id not found"));
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepository
				.findByCpf(username)
				.orElseThrow(() -> new UsernameNotFoundException("cpf not found"));
	}
	
	private void validade(Customer customer) {
		Stream<Customer> stream = customerRepository
				.findAll()
				.stream();
	
		stream.forEach((value) -> {
			if (customer.getCpf() == value.getCpf())
				throw new InvalidDataException("cpf, rg, email, contact or password exists");
			if (customer.getRg() == value.getRg())
				throw new InvalidDataException("cpf, rg, email, contact or password exists");
			if (customer.getEmail() == value.getEmail())
				throw new InvalidDataException("cpf, rg, email, contact or password exists");
			if (customer.getContact() == value.getContact())
				throw new InvalidDataException("cpf, rg, email, contact or password exists");
			if (crypt().matches(customer.getPassword(), value.getPassword()))
				throw new InvalidDataException("cpf, rg, email, contact or password exists");
		});
	}
	
	private BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}
