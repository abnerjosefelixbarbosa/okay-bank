package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Customer;

@Component
public class CustomerInfraMapper {
	public Customer toCustomer(CustomerDTO dto) {
		return new Customer(
				null,
				dto.name(),
				dto.email(),
				dto.password(),
				dto.contact(),
				dto.cpf(),
				dto.rg(),
				dto.birthDate(),
				dto.addressPostalCode(),
				dto.addressNumber(),
				dto.addressName(),
				dto.addressDistrict(),
				dto.addressCity(),
				dto.addressState()
		);
	}
	
	public CustomerDTO toCustomerDTO(Customer customer) {
		return new CustomerDTO(
				customer.getId(),
				customer.getName(),
				customer.getEmail(),
				customer.getPassword(),
				customer.getContact(),
				customer.getCpf(),
				customer.getRg(),
				customer.getBirthDate(),
				customer.getAddressPostalCode(),
				customer.getAddressNumber(),
				customer.getAddressName(),
				customer.getAddressDistrict(),
				customer.getAddressCity(),
				customer.getAddressState()
		);
	}
}