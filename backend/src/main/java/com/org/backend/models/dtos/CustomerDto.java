package com.org.backend.models.dtos;

import java.time.LocalDate;

import com.org.backend.models.entities.Customer;

import lombok.Data;

@Data
public class CustomerDto {
	private String id;
	private String cpf;
	private String rg;
	private String password;
	private String telephone;
	private String email;
	private LocalDate birthDate;
	private String name;
	private Integer addressNumber;
	private String addressZipCode;
	private String address;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
	private EmployeeDto employee;
	
	public void loginByCpfAndPassword(Customer customer) {
		this.id = customer.getId();
	}
}
