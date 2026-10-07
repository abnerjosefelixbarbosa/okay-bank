package com.okaybank.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDTO {
	private String id;
	private String matriculation;
	private LocalDate birthDate;
	private String cpf;
	private String name;
	private BigDecimal salary;
	private String email;
	private String phone;
	private Integer journey;
	private EmployeeType employeeType;
	private EmployeeStatus employeeStatus;
	private String postalCode;
	private String addressName;
	private Integer number;
	private String district;
	private String city;
	private String state;
}
