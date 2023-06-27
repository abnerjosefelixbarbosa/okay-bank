package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.AccountInterface;
import com.org.backend.models.Account;
import com.org.backend.repositories.AccountRepository;

@Service
public class AccountService implements AccountInterface {
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> listAllByAccount(String id) {	
		var result = accountRepository.findByCustomerId(id);
		result.stream().forEach((val) -> {
			val.getCustomer().setEmployee(null);
			val.getAgency().setEmployee(null);
			val.setEmployee(null);
		});	
		return result;
	}
	
	public Account findByAgencyAndAccount(String agency, String account) {
		var result = accountRepository.findByAgencyAgencyAndAccount(agency, account).orElseThrow(() -> {
			return new EntityNotFoundException("Agency and account not found");
		});
		result.setEmployee(null);
		result.getAgency().setEmployee(null);
		result.getCustomer().setEmployee(null);
		return result;
	}
}
