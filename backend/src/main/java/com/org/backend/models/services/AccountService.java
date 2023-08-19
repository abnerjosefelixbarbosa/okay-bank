package com.org.backend.models.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.backend.controllers.exceptions.EntityBadRequestException;
import com.org.backend.controllers.exceptions.EntityNotFoundException;
import com.org.backend.models.dtos.AccountDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountDto;
import com.org.backend.models.dtos.AccountTransferBalanceDto;
import com.org.backend.models.interfaces.AccountMethods;
import com.org.backend.models.repositories.AccountRepository;

@Service
public class AccountService implements AccountMethods {
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountDto getById(String id) {
		var account = accountRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Id not found");
		});
		var responseDto = new AccountDto(account);
		return responseDto;
	}
	
	public List<AccountDto> getAllByCustomerId(String id) {
		var pageRequest = PageRequest.of(0, 20, Sort.by("id"));
		var accounts = accountRepository.findByCustomerId(id, pageRequest); 
		var responseDtos = new LinkedList<AccountDto>();
		accounts.stream().forEach((val) -> {	
			var responseDto = new AccountDto(val);
			responseDtos.add(responseDto);
		});	
		return responseDtos;
	}
	
	public AccountDto findByAgencyAndAccount(AccountFindByAgencyAndAccountDto requestDto) {
		var account = accountRepository.findByAgencyAgencyAndAccount(requestDto.getAgency(), requestDto.getAccount()).orElseThrow(() -> {
			throw new EntityNotFoundException("Agency and account not found");
		});
		var responseDto = new AccountDto(account);
		return responseDto;
	}
	
	public AccountDto transferBalance(String id1, String id2, AccountTransferBalanceDto requestDto) {
		if (id1.equals(id2)) {
        	throw new EntityBadRequestException("id1 is equal to id2");
        }
		var account1 = accountRepository.findById(id1).orElseThrow(() -> {
        	throw new EntityNotFoundException("id1 not found");
        });
        var account2 = accountRepository.findById(id2).orElseThrow(() -> {
        	throw new EntityNotFoundException("id2 not found");
        });
        account1.withdraw(requestDto.getBalance());
        account2.deposit(requestDto.getBalance());
        accountRepository.save(account1);
        accountRepository.save(account2);
        var responseDto = new AccountDto(account1);
        return responseDto;
	}
}
