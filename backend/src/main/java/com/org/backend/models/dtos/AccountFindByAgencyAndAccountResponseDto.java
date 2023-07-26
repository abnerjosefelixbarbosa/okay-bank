package com.org.backend.models.dtos;

import com.org.backend.models.entities.Account;

import lombok.Data;

@Data
public class AccountFindByAgencyAndAccountResponseDto {
	private String id;

	public AccountFindByAgencyAndAccountResponseDto(Account account) {
		this.id = account.getId();
	}
}
