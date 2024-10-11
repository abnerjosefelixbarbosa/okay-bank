package com.api.backend_java.domain.entity;

import java.time.LocalDate;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private String id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String cpf;
	private String rg;
	private LocalDate birthDate;
	private String addressPostalCode;
	private String addressNumber;
	private String addressName;
	private String addressDistrict;
	private String addressState;
	private String addressCity;
	
	public Customer(CreateAccountDTO dto) {
		this.id = dto.getCustomerId();
	}
}