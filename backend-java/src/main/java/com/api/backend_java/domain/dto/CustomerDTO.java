package com.api.backend_java.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerDTO(
		String id,
		@NotNull(message = "name null")
		@NotEmpty(message = "name empty")
		@Size(max = 100, message = "name with in maximum 100 character")
		String name,
		@NotNull(message =  "email null")
		@NotEmpty(message = "email empty")
		@Email(message = "email invalid")
		@Size(max = 50, message = "name with in maximum 50 character")
		String email,
		@NotNull(message =  "password null")
		@NotEmpty(message =  "password empty")
		@Pattern(regexp = "^\\d{8}$", message = "password with 8 numeric digits")
		String password,
		@NotNull(message =  "contact null")
		@NotEmpty(message =  "contact empty")
		@Size(max = 20, message = "contact with in maximum 20 numeric digits")
		String contact,
		@NotNull(message = "cpf null")
		@NotEmpty(message = "cpf empty")
		@CPF(message = "cpf invalid")
		@Pattern(regexp = "^\\d{11}$", message = "cpf with 11 numeric digits")
		String cpf,
		@NotNull(message = "rg null")
		@NotEmpty(message = "rg empty")
		@Size(max = 10, message = "rg with in maximum 10 numeric digits")
		String rg,
		@NotNull(message = "birth date null")
		@Past(message = "birth date present or future")
		LocalDate birthDate,
		@NotNull(message = "address postal code null")
		@NotEmpty(message = "address postal code empty")
		@Size(max = 10, message = "address postal code with in maximum 10 character")
		String addressPostalCode,
		@NotNull(message = "address number null")
		@NotEmpty(message = "address number empty")
		@Size(max = 4, message = "address number with in maximum 4 character")
		@Pattern(regexp = "^\\d+$", message = "address number with numeric digits")
		String addressNumber,
		@NotNull(message = "address name null")
		@NotEmpty(message = "address name empty")
		@Size(max = 50, message = "address name with in maximum 50 character")
		String addressName,
		@NotNull(message = "address district null")
		@NotEmpty(message = "address district empty")
		@Size(max = 30, message = "address district with in maximum 30 character")
		String addressDistrict,
		@NotNull(message = "address city null")
		@NotEmpty(message = "address city empty")
		@Size(max = 30, message = "address city with in maximum 30 character")
		String addressCity,
		@NotNull(message = "address state null")
		@NotEmpty(message = "address state empty")
		@Size(max = 30, message = "address state with in maximus 30 character")
		String addressState
) {
}