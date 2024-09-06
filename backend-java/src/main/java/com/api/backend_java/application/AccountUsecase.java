package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountUsecase implements IAccountUsercase {
	private IAccountGateway accountGateway;

	public AccountDTO create(AccountDTO dto) {
		validate(null);
		return accountGateway.create(dto);
	}
	
	private void validate(Account account) {
		 boolean isAgencyIdNull = account.getAgency().getId() == null;
		 boolean isCustomerIdNull = account.getCustomer().getId() == null;
		 boolean isAgencyIdEmpty = account.getAgency().getId().isEmpty();
		 boolean isCustomerIdEmpty = account.getCustomer().getId().isEmpty();
		
		if (isAgencyIdNull || isAgencyIdEmpty)
			throw new InvalidDataException("agency id null or empty");
		if (isCustomerIdNull || isCustomerIdEmpty)
			throw new InvalidDataException("customer id null or empty");
	}
}
