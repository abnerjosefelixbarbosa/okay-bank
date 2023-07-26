package com.org.backend.models.dtos;

import java.math.BigDecimal;

import com.org.backend.models.entities.Account;

import lombok.Data;

@Data
public class AccountGetByIdResponseDto {
	private String id;
	private String account;
	private BigDecimal balance;	
	private String agencyAgency;
	private String customerName;
	
	public AccountGetByIdResponseDto(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();		
		this.balance = account.getBalance();
		this.agencyAgency = account.getAgency().getAgency();
		this.customerName = account.getCustomer().getName();
	}
}
