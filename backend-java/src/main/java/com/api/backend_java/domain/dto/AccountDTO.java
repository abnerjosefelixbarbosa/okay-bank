package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import com.api.backend_java.domain.entity.AccountType;

public record AccountDTO(
		String id,
		String number,
		BigDecimal balance,
		AccountType accountType,
		String password,
		CustomerDTO customer,
		AgencyDTO agency
) {
}