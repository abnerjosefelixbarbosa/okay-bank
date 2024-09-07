package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.mapper.AccountDomainMapper;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountUsecase implements IAccountUsercase {
	private IAccountGateway accountGateway;
	private AccountDomainMapper accountMapper;

	public AccountDTO create(AccountDTO dto) {
		Account account = accountMapper.toAccount(dto);
		validate(account);
		return accountGateway.create(dto);
	}
	
	private void validate(Account account) {
		System.out.println(account.getAgency().getId());
		if (account.getAgency().getId().isEmpty()) 
		    throw new InvalidDataException("customer id empty");
		else if (account.getAgency().getId().isEmpty())
			throw new InvalidDataException("agency id empty");
	}
}
