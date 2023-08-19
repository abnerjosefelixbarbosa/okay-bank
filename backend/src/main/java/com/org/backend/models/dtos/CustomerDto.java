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

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.cpf = customer.getCpf();
		this.rg = customer.getRg();
		this.password = customer.getPassword();
		this.telephone = customer.getTelephone();
		this.email = customer.getEmail();
		this.birthDate = customer.getBirthDate();
		this.name = customer.getName();
		this.addressNumber = customer.getAddressNumber();
		this.addressZipCode = customer.getAddressZipCode();
		this.address = customer.getAddress();
		this.addressDistrict = customer.getAddressDistrict();
		this.addressCity = customer.getAddressCity();
		this.addressState = customer.getAddressState();
		this.employee = new EmployeeDto(customer.getEmployee());
	}
}
