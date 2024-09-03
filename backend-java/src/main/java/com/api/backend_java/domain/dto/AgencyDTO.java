package com.api.backend_java.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgencyDTO(
		String id,
		@NotEmpty(message = "number empty")
		@NotNull(message = "number null")
		@Size(max = 10, message = "number with max 10 charactes")
		@Pattern(regexp = "^\\d+$", message = "number with numeric digits")
		String number
) {
	
}