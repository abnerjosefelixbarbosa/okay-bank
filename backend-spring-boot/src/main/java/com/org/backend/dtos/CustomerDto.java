package com.org.backend.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.org.backend.models.Customer;
import com.org.backend.models.Employee;

import lombok.Data;

@Data
public class CustomerDto {
	private String id;
	private String cpf;
	private String rg;
	private String password;
	private String telephone;
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	private String name;
	private Integer addressNumber;
	private String addressZipCode;
	private String address;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
	private Employee employee;
	
	public void setLoginByCpfAndPassword(Customer customer) {
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
	}
}
