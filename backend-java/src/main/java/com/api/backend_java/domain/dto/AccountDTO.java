package com.api.backend_java.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.api.backend_java.domain.entity.AccountDomainType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AccountDTO(
		@NotNull(message = "number must not be null")
		@NotEmpty(message = "number must not be empty")
		@Size(max = 10, message = "number must be max 10")
		@Pattern(regexp = "^\\d+$", message = "number must have numeric digits")
		String accountNumber,
	    @NotNull(message = "password must not be null")
		@NotEmpty(message = "password must not be empty")
		@Pattern(regexp = "^\\d{6}$", message = "password must have 8 numeric digits")
		String accountPassword,
		@NotNull(message = "account type must not be null")
		AccountDomainType accountType,
		@NotNull(message = "agency number must not be null")
		@NotEmpty(message = "agency number must not be empty")
		@Size(max = 10, message = "agency number must be max 10")
		@Pattern(regexp = "^\\d+$", message = "agency number must have numeric digits")
		String agencyNumber,
		@NotNull(message = "customer cpf must not be null")
		@NotEmpty(message = "customer cpf must not be empty")
		@Pattern(regexp = "^\\d{11}$", message = "customer cpf must have 11 numeric digits")
		@CPF(message = "customer cpf must not be invalid")
		String customerCpf,
		@NotNull(message = "customer rg must not be null")
		@NotEmpty(message = "customer rg must not be empty")
		@Pattern(regexp = "^\\d+$", message = "customer rg must have numeric digits")
		@Size(max = 10, message = "customer rg must be max 10")
		String customerRg,
		@NotNull(message = "customer name must not be null")
		@NotEmpty(message = "customer name must not be empty")
		@Size(max = 100, message = "customer name must be max 100")
		String customerName,
		@NotNull(message = "customer email must not be null")
		@NotEmpty(message = "customer email must not be empty")
		@Email(message = "customer email must not be invalid")
		@Size(max = 50, message = "customer email must be max 50")
		String customerEmail,
		@NotNull(message = "customer contact must not be null")
		@NotEmpty(message = "customer contact must not be empty")
		@Size(max = 20, message = "customer contact must be max 20")
		@Pattern(regexp = "^\\d+$", message = "customer contact must have numeric digits")
		String customerContact,
		@NotNull(message = "customer password must not be null")
		@NotEmpty(message = "customer password must not be empty")
		@Pattern(regexp = "^\\d{8}$", message = "customer password must have 6 numeric digits")
		String customerPassword,
		@NotNull(message = "customer birth date must not be null")
		@Past(message = "customer birth date must be pasted")
		LocalDate customerBirthDate,
		@NotNull(message = "address postal code must not be null")
		@NotEmpty(message = "address poatal code must not be empty")
		@Pattern(regexp = "^\\d+$", message = "address poatal code must have numeric digits")
		String addressPostalCode,
		@NotNull(message = "address number must not be null")
		@NotEmpty(message = "address number must not be empty")
		@Pattern(regexp = "^\\d+$", message = "address number must have numeric digits")
		@Size(max = 4, message = "address number must be max 4")
		String addressNumber,
		@NotNull(message = "address name must not be null")
		@NotEmpty(message = "address name must not be empty")
		@Size(max = 50, message = "address name must be max 50")
	    String addressName,
	    @NotNull(message = "address district must not be null")
		@NotEmpty(message = "address district must not be empty")
		@Size(max = 30, message = "address district must be max 30")
	    String addressDistrict,
	    @NotNull(message = "address state must not be null")
		@NotEmpty(message = "address state must not be empty")
		@Size(max = 30, message = "address state must be max 30")
		String addressState,
		@NotNull(message = "address city must not be null")
		@NotEmpty(message = "address city must not be empty")
		@Size(max = 30, message = "address city must be max 30")
		String addressCity
) {}