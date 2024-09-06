package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.repository.IAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements IAccountGateway {
	private IAccountRepository accountRepository;
	private IAgencyGateway agencyGateway; 
	private ICustomerGateway customerGateway;

	public AccountDTO create(AccountDTO dto) {
		return null;
	}
	
	private void validade(Account account) {		
	}
}
