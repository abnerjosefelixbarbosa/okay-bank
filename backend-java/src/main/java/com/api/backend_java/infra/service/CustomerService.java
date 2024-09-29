package com.api.backend_java.infra.service;

import java.util.stream.Stream;

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
		customer.setPassword(crypt().encode(customer.getPassword()));
		customer = customerRepository.save(customer);
		return customerMapper.toCustomerDTO(customer);
	}

	public CustomerDTO login(LoginCustomerDTO dto) {
		Customer customer = customerMapper.toCustomer(dto);
		validadePassword(customer);
		customer = customerRepository.findByCpfAndPassword(dto.getCpf(), dto.getPassword())
				.orElseThrow(() -> new NotFoundException("customer not found"));
		return customerMapper.toCustomerDTO(customer);
	}

	public Customer getById(String id) {
		return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("customer id not found"));
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepository.findByCpf(username).orElseThrow(() -> new UsernameNotFoundException("cpf not found"));
	}
	
	private void validade(Customer customer) {
		boolean existsByCpfOrRgOrEmailOrContactOrPassword = customerRepository
				.existsByCpfOrRgOrEmailOrContactOrPassword(customer.getCpf(), customer.getRg(), customer.getEmail(),
						customer.getContact(), customer.getPassword());
		Stream <Customer> stream = customerRepository.findAll().parallelStream();
		if (existsByCpfOrRgOrEmailOrContactOrPassword)
			throw new InvalidDataException("cpf, rg, email, contact or password exists");
		stream.anyMatch((value) -> {
			if (crypt().matches(customer.getPassword(), value.getPassword()))
				throw new InvalidDataException("password exist");
			return false;
		});
	}
	
	private void validadePassword(Customer customer) {
		Stream <Customer> stream = customerRepository.findAll().parallelStream();
		stream.anyMatch((value) -> {
			if (crypt().matches(customer.getPassword(), value.getPassword()))
				throw new InvalidDataException("password exist");
			return false;
		});
	}
	
	private BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}
