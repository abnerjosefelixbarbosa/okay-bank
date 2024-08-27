package com.api.backend_java.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private String id;
	private String cpf;
	private String rg;
	private String name;
	private String email;
	private String contact;
	private String password;
	private LocalDate birthDate;
	private Address address;
}