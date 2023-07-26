package com.org.backend.models.dtos;

import com.org.backend.models.entities.Account;

import lombok.Data;

@Data
public class AccountGetAllByCustomerIdResponseDto {
	private String id;
	private String account;	
	private String agencyAgency;
	
	public AccountGetAllByCustomerIdResponseDto(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();
		this.agencyAgency = account.getAgency().getAgency();
	}
}
