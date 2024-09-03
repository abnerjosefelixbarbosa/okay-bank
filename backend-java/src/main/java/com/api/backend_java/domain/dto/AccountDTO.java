package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import com.api.backend_java.domain.entity.AccountType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AccountDTO(
		String id,
		@NotNull(message = "number null")
		@NotEmpty(message = "number empty")
		@Size(max = 10, message = "number with max 10 character")
		@Pattern(regexp = "^\\d+$", message = "number with numeric digits")
		String number,
		@NotNull(message = "balance null")
		BigDecimal balance,
		@NotNull(message = "account null")
		AccountType accountType,
		@NotNull(message = "password null")
		@NotEmpty(message = "password empty")
		@Pattern(regexp = "^\\d{6}$", message = "password with 8 numeric digits")
		String password,
		@NotNull(message = "customer null")
		CustomerDTO customer,
		@NotNull(message =  "agency null")
		AgencyDTO agency
) {
}