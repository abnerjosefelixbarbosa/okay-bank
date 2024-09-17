package com.api.backend_java.infra.service;

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
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerGateway {
	private final ICustomerRepository customerRepository;
	private final CustomerInfraMapper customerMapper;

	public boolean existsByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact,
			String password) {
		return customerRepository.existsByCpfOrRgOrEmailOrContactOrPassword(cpf, rg, email, contact, password);
	}

	@Transactional
	public CustomerDTO create(CreateCustomerDTO dto) {
		Customer customer = customerMapper.toCustomer(dto);
		validade(customer);
		customer = customerRepository.save(customer);
		return customerMapper.toCustomerDTO(customer);
	}
	
	public CustomerDTO login(LoginCustomerDTO dto) {
		Customer customer = customerMapper.toCustomer(dto);
		customer = customerRepository.findByCpfAndPassword(
				dto.cpf(),
				dto.password()
		).orElseThrow(() -> new NotFoundException("customer not found"));
		return customerMapper.toCustomerDTO(customer);
	}
	
	public Customer getById(String id) {
		return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("customer id not found"));
	}
	
	private void validade(Customer customer) {
		boolean existsByCpfOrRgOrEmailOrContactOrPassword = customerRepository.existsByCpfOrRgOrEmailOrContactOrPassword(
						customer.getCpf(),
						customer.getRg(),
						customer.getEmail(),
						customer.getContact(),
						customer.getPassword()
		);
		
		if (existsByCpfOrRgOrEmailOrContactOrPassword)
			throw new InvalidDataException("cpf, rg, email, contact or password exists");
	}
}
