package com.okay_bank.backend.application.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	private LocalDate creationDate;
	private String password;
	private AccountType accountType;
	private Customer customer;
	private Agency agency;
	private List<AccountTransfer> accountTransfers;
}
