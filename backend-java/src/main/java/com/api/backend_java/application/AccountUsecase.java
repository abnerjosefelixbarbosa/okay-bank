package com.api.backend_java.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.mapper.AccountDomainMapper;
import com.api.backend_java.domain.usercase.IAccountUsercase;

@Component
public class AccountUsecase implements IAccountUsercase {
	@Autowired
	private IAccountGateway accountGateway;
	@Autowired
	private AccountDomainMapper accountMapper;

	public AccountDTO create(CreateAccountDTO dto) {
		Account account = accountMapper.toAccount(dto);
		validate(account);
		
		return accountGateway.create(dto);
	}
	
	public AccountDTO enter(EnterAccountDTO dto) {
		return accountGateway.enter(dto);
	}
	
	public AccountDTO tranfer(String idAccount1, String idAccount2, TransferAccountDTO dto) {
		return null;
	}
	
	private void validate(Account account) {
		boolean isCustomerIdNull = account.getCustomer().getId() == null;
		boolean isCustomerIdEmpty = account.getCustomer().getId().isEmpty();
		boolean isAgencyIdNull = account.getAgency().getId() == null;
		boolean isAgencyIdEmpty = account.getAgency().getId().isEmpty();
		
		if (isCustomerIdNull) 
		    throw new InvalidDataException("customer id null");
		if (isCustomerIdEmpty) 
		    throw new InvalidDataException("customer id empty");
		if (isAgencyIdNull)
			throw new InvalidDataException("agency id null");
		if (isAgencyIdEmpty)
			throw new InvalidDataException("agency id empty");
	}
}
