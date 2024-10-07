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
				.parallelStream();	
		boolean exists = stream.anyMatch((value) -> {
			if (customer.getCpf().equals(value.getCpf()))
				return true;
			if (customer.getRg().equals(value.getRg()))
				return true;
			if (customer.getEmail().equals(value.getEmail()))
				return true;
			if (customer.getContact().equals(value.getContact()))
				return true;
			if (crypt().matches(customer.getPassword(), value.getPassword()))
				return true;
			
			return false;
		});
		
		if (exists)
			throw new InvalidDataException("cpf, rg, email, contact or password exists");
	}
	
	private BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}
