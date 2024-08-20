package com.org.back_end_java.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class Account {
	private String id;
	private String number;
	private BigDecimal balance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private String password;
	private Customer customer;
	private Agency agency;
}