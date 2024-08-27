package com.api.backend_java.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgencyDTO(
		@NotEmpty(message = "number not must be empty")
		@NotNull(message = "number not must be null")
		@Size(max = 10, message = "number must be max 10")
		@Pattern(regexp = "^\\d+$", message = "number must have numeric digits")
		String number
) {}