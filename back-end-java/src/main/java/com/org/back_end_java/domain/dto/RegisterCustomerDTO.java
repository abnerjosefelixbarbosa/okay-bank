package com.org.back_end_java.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.org.back_end_java.domain.entity.AccountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterCustomerDTO {
	@NotNull
	@NotEmpty
	private String customerName;
	@NotNull
	@NotEmpty
	@Email
	private String customerEmail;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^\\d{8}$")
	private String customerPassword;
	@NotNull
	@NotEmpty
	private String customerContact;
	@NotNull
	@NotEmpty
	@CPF
	private String customerCpf;
	@NotNull
	@NotEmpty
	private String customerRg;
	@NotNull
	@Past
	private LocalDate customerBirthDate;
	
	@NotNull
	@NotEmpty
	private String addressPostalCode;
	@NotNull
	@NotEmpty
	private String addressNumber;
	@NotNull
	@NotEmpty
	private String addressName;
	@NotNull
	@NotEmpty
	private String addressDistrict;
	@NotNull
	@NotEmpty
	private String addressCity;
	@NotNull
	@NotEmpty
	private String addressState;
	
	@NotNull
	@NotEmpty
	private String accountNumber;
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^\\d{6}$")
	private String accountPassword;
	
	@NotNull
	@NotEmpty
	private String agencyNumber;
}