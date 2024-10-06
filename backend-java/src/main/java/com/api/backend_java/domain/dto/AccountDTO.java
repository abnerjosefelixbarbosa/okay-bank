package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import com.api.backend_java.domain.entity.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	private String id;
	private String number;
	private BigDecimal balance;
	private AccountType accountType;
	private String password;
	private CustomerDTO customer;
	private AgencyDTO agency;
}