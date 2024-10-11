package com.api.backend_java.domain.entity;

import java.math.BigDecimal;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;

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
	private AccountType accountType;
	private String password;
	private Customer customer;
	private Agency agency;
	
	public Account(CreateAccountDTO dto) {
		this.number = dto.getNumber();
		this.balance = BigDecimal.ZERO;
		this.accountType = dto.getAccountType();
		this.password = dto.getPassword();
	}

	public Account(TransferAccountDTO dto) {
		this.balance = dto.getBalance();
	}
}
