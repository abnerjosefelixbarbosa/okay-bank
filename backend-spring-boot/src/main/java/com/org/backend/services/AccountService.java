package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.interfaces.AccountInterface;
import com.org.backend.models.Account;
import com.org.backend.repositories.AccountRepository;

@Service
public class AccountService implements AccountInterface {
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> listAllByAccount(String id) {	
		var accounts = accountRepository.findByCustomerId(id);
		accounts.stream().forEach((val) -> {
			val.getCustomer().setEmployee(null);
			val.getAgency().setEmployee(null);
			val.setEmployee(null);
		});	
		return accounts;
	}
}
