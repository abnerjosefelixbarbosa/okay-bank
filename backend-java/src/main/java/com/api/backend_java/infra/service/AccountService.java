package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.mapper.AccountInfraMapper;
import com.api.backend_java.infra.repository.IAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements IAccountGateway {
	private IAccountRepository accountRepository;
	private AccountInfraMapper accountMapper;

	public AccountView create(AccountDTO dto) {
		Account account = accountMapper.toAccount(dto);
		account = accountRepository.save(account);
		return accountMapper.toAccountView(account);
	}
}
