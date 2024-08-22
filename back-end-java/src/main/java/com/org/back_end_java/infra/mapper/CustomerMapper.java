package com.org.back_end_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.infra.entity.Address;
import com.org.back_end_java.infra.entity.Customer;

@Component
public class CustomerMapper {
	
	public Customer toCustomer(RegisterCustomerDTO dto) {
		Address address = new Address();
		address.setAddressName(dto.getAddressName());
		address.setCity(dto.getAddressCity());
		address.setDistrict(dto.getAddressDistrict());
		address.setNumber(dto.getAddressNumber());
		address.setPostalCode(dto.getAddressPostalCode());
		address.setState(dto.getAddressState());
		
		Customer customer = new Customer();
		customer.setName(dto.getCustomerName());
		customer.setBirthDate(dto.getCustomerBirthDate());
		customer.setContact(dto.getCustomerContact());
		customer.setCpf(dto.getCustomerCpf());
		customer.setRg(dto.getCustomerRg());
		customer.setEmail(dto.getCustomerEmail());
		customer.setPassword(dto.getCustomerPassword());
		customer.setAddress(address);
		
		return customer;
	}
	
}
