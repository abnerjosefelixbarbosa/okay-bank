package com.api.backend_java.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String id;
	private String number;
	private BigDecimal balance;
	private String password;
	private AccountType accountType;
	private Agency agency;
	private Customer customer;
}