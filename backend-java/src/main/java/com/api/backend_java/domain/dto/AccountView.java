package com.api.backend_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.backend_java.domain.entity.AccountType;

public record AccountView(
		String id,
		String number,
	    BigDecimal balance,
		String password,
		AccountType accountType,
		String agencyId,
		String agencyNumber,
		String customerId,
		String customerCpf,
		String customerRg,
		String customerName,
		String customerEmail,
		String customerContact,
		String customerPassword,
		LocalDate customerBirthDate,
		String addressPostalCode,
		String addressNumber,
	    String addressName,
	    String addressDistrict,
		String addressState,
		String addressCity
) {}