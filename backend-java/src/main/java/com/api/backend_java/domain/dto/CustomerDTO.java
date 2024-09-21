package com.api.backend_java.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
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
	private String addressCity;
	private String addressState;
}