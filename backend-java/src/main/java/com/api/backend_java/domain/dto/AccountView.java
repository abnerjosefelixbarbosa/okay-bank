package com.api.backend_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.backend_java.domain.entity.AccountType;
import com.api.backend_java.infra.entity.Account;

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
		LocalDate customerbirthDate,
		String addressPostalCode,
		String addressNumber,
		String addressName,
	    String addressDistrict,
		String addressState,
		String addressCity
) {
	public AccountView(Account account) {
		this(
				account.getId(),
				account.getNumber(),
				account.getBalance(),
				account.getPassword(), 
				AccountType.valueOf(account.getAccountType().getValue()),
				account.getAgency().getId(),
				account.getAgency().getNumber(),
				account.getCustomer().getId(),
				account.getCustomer().getCpf(),
				account.getCustomer().getRg(),
				account.getCustomer().getName(),
				account.getCustomer().getEmail(),
				account.getCustomer().getContact(),
				account.getCustomer().getPassword(),
				account.getCustomer().getBirthDate(),
				account.getCustomer().getAddress().getPostalCode(),
				account.getCustomer().getAddress().getNumber(),
				account.getCustomer().getAddress().getName(),
				account.getCustomer().getAddress().getDistrict(),
				account.getCustomer().getAddress().getState(),
				account.getCustomer().getAddress().getCity()
		);
	}
}