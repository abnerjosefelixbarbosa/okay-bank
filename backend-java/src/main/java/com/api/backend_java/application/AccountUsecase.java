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
		
		if (account.getCustomer().getId() == null) 
		    throw new InvalidDataException("customer id null");
		if (account.getCustomer().getId().isEmpty()) 
		    throw new InvalidDataException("customer id empty");
		if (account.getAgency().getId() == null)
			throw new InvalidDataException("agency id null");
		if (account.getAgency().getId().isEmpty())
			throw new InvalidDataException("agency id empty");
	}
}
