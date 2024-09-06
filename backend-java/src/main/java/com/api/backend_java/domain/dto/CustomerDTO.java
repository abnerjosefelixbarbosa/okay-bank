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
		@NotNull
		@NotEmpty
		@Size(max = 100)
		String name,
		@NotNull
		@NotEmpty
		@Email
		@Size(max = 50)
		String email,
		@NotNull
		@NotEmpty
		@Pattern(regexp = "^\\d{8}$")
		String password,
		@NotNull
		@NotEmpty
		@Size(max = 20)
		String contact,
		@NotNull
		@NotEmpty
		@CPF
		String cpf,
		@NotNull
		@NotEmpty
		@Size(max = 10)
		String rg,
		@NotNull
		@Past
		LocalDate birthDate,
		@NotNull
		@NotEmpty
		@Size(max = 10)
		String addressPostalCode,
		@NotNull
		@NotEmpty
		@Size(max = 4)
		String addressNumber,
		@NotNull
		@NotEmpty
		@Size(max = 50)
		String addressName,
		@NotNull
		@NotEmpty
		@Size(max = 30)
		String addressDistrict,
		@NotNull
		@NotEmpty
		@Size(max = 30)
		String addressCity,
		@NotNull
		@NotEmpty
		@Size(max = 30)
		String addressState
) {
}