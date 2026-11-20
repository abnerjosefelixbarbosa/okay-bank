package com.okay_bank.backend.infra.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgencyRequestDTO(
		@NotNull(message = "O número não deve ser nulo ou vázio.")
		@NotEmpty(message = "O número não deve ser nulo ou vázio.")
		@Size(message = "O número não deve ter apenas 5 caracteres.", min = 5, max = 5)
		@Pattern(message = "O número deve ter caracteres numéricos.", regexp = "^[0-9]+$")
		String number
) {}