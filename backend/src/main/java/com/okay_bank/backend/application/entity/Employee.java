package com.okay_bank.backend.application.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private String id;
	private String matriculation;
	private LocalDate birthDate; 
	private String cpf;
	private String name;
	private BigDecimal salary;
	private Address address;
	private String email;
	private String phone;
	private String password;
	private EmployeeType employeeType;
	private EmployeeStatus employeeStatus;
	private Agency agency;
}
