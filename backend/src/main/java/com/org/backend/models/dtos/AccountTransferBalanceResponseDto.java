package com.org.backend.models.dtos;

import com.org.backend.models.entities.Account;

import lombok.Data;

@Data
public class AccountTransferBalanceResponseDto {
	private String id;

	public AccountTransferBalanceResponseDto(Account account) {
		this.id = account.getId();
	}
}
