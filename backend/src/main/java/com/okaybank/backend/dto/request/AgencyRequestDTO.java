package com.okaybank.backend.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgencyRequestDTO(
		@NotNull(message = "Numero deve ser obrigatório.")
		@NotEmpty(message = "Numero deve ser obrigatório.")
		@Size(min = 5, max = 5, message = "Numero deve ter 5 caracteres numéricos.")
		@Pattern(regexp = "^[0-9]*$", message = "Numero deve ter 5 caracteres numéricos.")
		String number
) {}