package com.api.backend_java.domain.dto;

import java.time.LocalDate;

import com.api.backend_java.infra.entity.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private String id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String cpf;
	private String rg;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private LocalDate birthDate;
	private String addressPostalCode;
	private String addressNumber;
	private String addressName;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.password = customer.getPassword();
		this.contact = customer.getContact();
		this.cpf = customer.getCpf();
		this.rg = customer.getRg();
		this.birthDate = customer.getBirthDate();
		this.addressPostalCode = customer.getAddressPostalCode();
		this.addressNumber = customer.getAddressNumber();
		this.addressName = customer.getAddressName();
		this.addressDistrict = customer.getAddressDistrict();
		this.addressCity = customer.getAddressCity();
		this.addressState = customer.getAddressState();
	}
}