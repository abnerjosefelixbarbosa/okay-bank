package com.org.back_end_java.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.back_end_java.infra.entity.Account;
import com.org.back_end_java.infra.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;

	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public boolean existsAccount(Account account) {
		return accountRepository.existsByNumberAndPassword(account.getNumber(), account.getPassword());
	}
}
