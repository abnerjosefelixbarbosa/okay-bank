package com.api.backend_java.infra.mapper;

import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.infra.entity.Customer;

@Component
public class CustomerInfraMapper {
	public Customer toCustomer(CreateCustomerDTO dto) {
		Customer customer = new Customer();
		customer.setId(UlidCreator.getUlid().toString());
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setPassword(dto.getPassword());
		customer.setContact(dto.getContact());
		customer.setCpf(dto.getCpf());
		customer.setRg(dto.getRg());
		customer.setBirthDate(dto.getBirthDate());
		customer.setAddressPostalCode(dto.getAddressPostalCode());
		customer.setAddressNumber(dto.getAddressNumber());
		customer.setAddressName(dto.getAddressName());
		customer.setAddressDistrict(dto.getAddressDistrict());
		customer.setAddressCity(dto.getAddressCity());
		customer.setAddressState(dto.getAddressState());

		return customer;
	}
	
	public Customer toCustomer(LoginCustomerDTO dto) {
		Customer customer = new Customer();
		customer.setPassword(dto.getPassword());
		customer.setCpf(dto.getCpf());

		return customer;
	}
	
	public CustomerDTO toCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setContact(customer.getContact());
		customerDTO.setCpf(customer.getCpf());
		customerDTO.setRg(customer.getRg());
		customerDTO.setBirthDate(customer.getBirthDate());
		customerDTO.setAddressPostalCode(customer.getAddressPostalCode());
		customerDTO.setAddressNumber(customer.getAddressNumber());
		customerDTO.setAddressName(customer.getAddressName());
		customerDTO.setAddressDistrict(customer.getAddressDistrict());
		customerDTO.setAddressCity(customer.getAddressCity());
		customerDTO.setAddressState(customer.getAddressState());

		return customerDTO;
	}
}