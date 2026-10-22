package com.okaybank.backend.mapper;

import com.okaybank.backend.dto.CustomerRequestDTO;
import com.okaybank.backend.dto.CustomerResponseDTO;
import com.okaybank.backend.model.Address;
import com.okaybank.backend.model.Customer;

public class CustomerMapper {
	public static Customer toCustomer(CustomerRequestDTO dto) {
		Address address = new Address(dto.getAddressPostalCode(), dto.getAddressName(), dto.getAddressNumber(),
				dto.getAddressDistrict(), dto.getAddressCity(), dto.getAddressState());

		Customer customer = new Customer(null, dto.getDocument(), dto.getBirthDate(), dto.getName(), dto.getEmail(),
				address, dto.getPhone(), dto.getCustomerType(), null, null);

		return customer;
	}

	public static CustomerResponseDTO toDTO(Customer customer) {
		CustomerResponseDTO response = new CustomerResponseDTO(customer.getId(), customer.getDocument(),
				customer.getBirthDate(), customer.getName(), customer.getEmail(), customer.getPhone(),
				customer.getCustomerType(), customer.getAddress().getPostalCode(), customer.getAddress().getName(),
				customer.getAddress().getNumber(), customer.getAddress().getDistrict(), customer.getAddress().getCity(),
				customer.getAddress().getState());

		return response;
	}
}
