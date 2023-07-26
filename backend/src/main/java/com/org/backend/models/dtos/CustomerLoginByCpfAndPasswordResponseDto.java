package com.org.backend.models.dtos;

import com.org.backend.models.entities.Customer;

import lombok.Data;

@Data
public class CustomerLoginByCpfAndPasswordResponseDto {
	private String id;

	public CustomerLoginByCpfAndPasswordResponseDto(Customer customer) {
		this.id = customer.getId();
	}
}