package com.org.backend.models.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.backend.controllers.exceptions.EntityNotFoundException;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountRequestDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountResponseDto;
import com.org.backend.models.dtos.AccountGetAllByIdResponseDto;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;
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
	
	public List<AccountGetAllByIdResponseDto> getAllByCustomerId(String id) {
		var pageRequest = PageRequest.of(0, 20, Sort.by("id"));
		var accounts = accountRepository.findByCustomerId(id, pageRequest);
		var responseDto = new AccountGetAllByIdResponseDto();		 
		var responseDtos = new LinkedList<AccountGetAllByIdResponseDto>();
		accounts.stream().forEach((val) -> {
			responseDto.setId(val.getId());
			responseDto.setAgency(val.getAgency().getAgency());
			responseDto.setAccount(val.getAccount());
			responseDtos.add(responseDto);
		});	
		return responseDtos;
	}
	
	public AccountFindByAgencyAndAccountResponseDto findByAgencyAndAccount(AccountFindByAgencyAndAccountRequestDto requestDto) {
		var account = accountRepository.findByAgencyAgencyAndAccount(requestDto.getAgency(), requestDto.getAccount()).orElseThrow(() -> {
			throw new EntityNotFoundException("Agency and account not found");
		});
		var responseDto = new AccountFindByAgencyAndAccountResponseDto();
		responseDto.setId(account.getId());
		return responseDto;
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
