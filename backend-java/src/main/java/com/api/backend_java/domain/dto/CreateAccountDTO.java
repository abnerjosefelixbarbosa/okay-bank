package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import com.api.backend_java.domain.entity.AccountType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAccountDTO(
		@NotNull(message = "number should not be null")
		@NotEmpty(message = "number should not be empty")
		@Size(max = 10, message = "number should have in maximum 10 character")
		@Pattern(regexp = "^\\d+$", message = "number should have numeric digits")
		String number,
		@NotNull(message = "balance should not be null")
		BigDecimal balance,
		@NotNull(message = "account should not be null")
		AccountType accountType,
		@NotNull(message = "password should not be null")
		@NotEmpty(message = "password should not be empty")
		@Pattern(regexp = "^\\d{6}$", message = "password should have 6 numeric digits")
		String password,
		@NotNull(message = "customer id should not be null")
		@NotEmpty(message = "customer id should not be empty")
		String customerId,
		@NotNull(message =  "agency id should not be null")
		@NotEmpty(message = "customer id should not be empty")
		String agencyId
) {
}