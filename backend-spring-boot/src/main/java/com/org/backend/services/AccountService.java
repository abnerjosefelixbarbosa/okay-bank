package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.interfaces.AccountInterface;
import com.org.backend.interfaces.CustomerInterface;
import com.org.backend.models.Account;
import com.org.backend.repositories.AccountRepository;

@Service
public class AccountService implements AccountInterface {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerInterface customerInterface;
	
	public List<Account> findAllByAccount(String id) {	
		var customer = customerInterface.findByid(id);
		return accountRepository.findByCustomer(customer);
	}
}
