package com.org.backend.models.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.controllers.exceptions.EntityNotFoundException;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;
import com.org.backend.models.entities.Account;
import com.org.backend.models.interfaces.AccountMethods;
import com.org.backend.models.repositories.AccountRepository;

@Service
public class AccountService implements AccountMethods {
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountGetByIdResponseDto getById(String id) {
		var account = accountRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Id not found");
		});
		var responseDto = new AccountGetByIdResponseDto();
		responseDto.setIdAccount(account.getId());
		responseDto.setAgency(account.getAgency().getAgency());
		responseDto.setAccount(account.getAccount());
		responseDto.setBalance(account.getBalance());
		responseDto.setNameCustomer(account.getCustomer().getName());
		return responseDto;
	}
	
	public List<Account> listAllByAccount(String id) {	
		var accountModels = accountRepository.findByCustomerId(id);
		accountModels.stream().forEach((val) -> {
			val.getCustomer().setEmployee(null);
			val.getAgency().setEmployee(null);
			val.setEmployee(null);
		});	
		return accountModels;
	}
	
	public Account findByAgencyAndAccount(String agency, String account) {
		var accountModel = accountRepository.findByAgencyAgencyAndAccount(agency, account).orElseThrow(() -> {
			throw new EntityNotFoundException("Agency and account not found");
		});
		accountModel.setEmployee(null);
		accountModel.getAgency().setEmployee(null);
		accountModel.getCustomer().setEmployee(null);
		return accountModel;
	}
	
	public String transferBalance(String id1, String id2, BigDecimal balance) {
        var accountModel1 = accountRepository.findById(id1).orElseThrow(() -> {
        	throw new EntityNotFoundException("id1 not found");
        });
        var accountModel2 = accountRepository.findById(id2).orElseThrow(() -> {
        	throw new EntityNotFoundException("id2 not found");
        });
        accountModel1.withdraw(balance);
        accountModel2.deposit(balance);
        accountRepository.save(accountModel1);
        accountRepository.save(accountModel2);
		return "Balance transfed";
	}
}
