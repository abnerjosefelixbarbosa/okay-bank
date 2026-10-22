package com.okaybank.backend.dto;

import java.time.LocalDate;

import com.okaybank.backend.model.CustomerType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDTO {
	private String id;
	private String document;
	private LocalDate birthDate;
	private String name;
	private String email;
	private String phone;
	private CustomerType customerType;
	private String addressPostalCode;
	private String addressName;
	private Integer addressNumber;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
}
