package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.models.Account;
import com.org.backend.models.Customer;
import com.org.backend.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerService customerService;
	
	public List<Account> findByCustomer(String id) {	
		Customer customer = customerService.findByid(id);
		return accountRepository.findByCustomer(customer);
	}
}
