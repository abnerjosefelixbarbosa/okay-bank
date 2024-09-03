package com.api.backend_java.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String id;
	private String number;
	private BigDecimal balance;
	private AccountType accountType;
	private String password;
	private Customer customer;
	private Agency agency;
}
