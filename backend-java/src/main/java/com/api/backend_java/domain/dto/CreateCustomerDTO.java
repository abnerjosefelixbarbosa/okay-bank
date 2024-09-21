package com.api.backend_java.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDTO {
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	@Size(max = 100, message = "name should be with in maximum 100 character")
	private String name;
	@NotNull(message =  "email should not be null")
	@NotEmpty(message = "email should not be empty")
	@Email(message = "email should not be invalid")
	@Size(max = 50, message = "name should have in maximum 50 character")
	private String email;
	@NotNull(message =  "password should not be null")
	@NotEmpty(message =  "password should not be empty")
	@Pattern(regexp = "^\\d{8}$", message = "password should have 8 numeric digits")
	private String password;
	@NotNull(message =  "contact should not be null")
	@NotEmpty(message =  "contact should not be empty")
	@Size(max = 20, message = "contact should have in maximum 20 numeric digits")
	@Pattern(regexp = "^\\d+$", message = "contact should have digit numerics")
	private String contact;
	@NotNull(message = "cpf should not be null")
	@NotEmpty(message = "cpf should not be empty")
	@CPF(message = "cpf should not be invalid")
	@Pattern(regexp = "^\\d{11}$", message = "cpf should have 11 numeric digits")
	private String cpf;
	@NotNull(message = "rg should not be null")
	@NotEmpty(message = "rg should not be empty")
	@Pattern(regexp = "^\\d+$", message = "rg should have numeric digits")
	@Size(max = 10, message = "rg should have maximum 10 numeric digits")
	private String rg;
	@NotNull(message = "birth date should not be null")
	@Past(message = "birth date should be past")
	private LocalDate birthDate;
	@NotNull(message = "address postal code should not be null")
	@NotEmpty(message = "address postal code should not be empty")
	@Pattern(regexp = "^\\d+$", message = "address postal code should have numeric digits")
	@Size(max = 10, message = "address postal code should have in maximum 10 character")
	private String addressPostalCode;
	@NotNull(message = "address number should not be null")
	@NotEmpty(message = "address number should not be empty")
	@Size(max = 4, message = "address number should have in maximum 4 character")
	@Pattern(regexp = "^\\d+$", message = "address number should have numeric digits")
	private String addressNumber;
	@NotNull(message = "address name should not be null")
	@NotEmpty(message = "address name should not be empty")
	@Size(max = 50, message = "address name should have in maximum 50 character")
	private String addressName;
	@NotNull(message = "address district should not be null")
	@NotEmpty(message = "address district should not be empty")
	@Size(max = 30, message = "address district should have in maximum 30 character")
	private String addressDistrict;
	@NotNull(message = "address city should not be null")
	@NotEmpty(message = "address city should not be empty")
	@Size(max = 30, message = "address city should have in maximum 30 character")
	private String addressCity;
	@NotNull(message = "address state should not be null")
	@NotEmpty(message = "address state should not be empty")
	@Size(max = 30, message = "address state should have in maximus 30 character")
	private String addressState;
}