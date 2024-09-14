package com.api.backend_java.domain.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LoginDTO(
		@NotNull
		@CPF
		@Pattern(regexp = "^//d{11}$")
		String cpf,
		@NotNull
		@Pattern(regexp = "^//d{8}$")
		String password
) {
}