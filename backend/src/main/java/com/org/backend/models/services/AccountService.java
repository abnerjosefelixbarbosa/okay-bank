package com.org.backend.models.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.backend.controllers.exceptions.EntityBadRequestException;
import com.org.backend.controllers.exceptions.EntityNotFoundException;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountRequestDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountResponseDto;
import com.org.backend.models.dtos.AccountGetAllByCustomerIdResponseDto;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;
import com.org.backend.models.dtos.AccountTransferBalanceRequestDto;
import com.org.backend.models.dtos.AccountTransferBalanceResponseDto;
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
		var responseDto = new AccountGetByIdResponseDto(account);
		return responseDto;
	}
	
	public List<AccountGetAllByCustomerIdResponseDto> getAllByCustomerId(String id) {
		var pageRequest = PageRequest.of(0, 20, Sort.by("id"));
		var accounts = accountRepository.findByCustomerId(id, pageRequest); 
		var responseDtos = new LinkedList<AccountGetAllByCustomerIdResponseDto>();
		accounts.stream().forEach((val) -> {
			var responseDto = new AccountGetAllByCustomerIdResponseDto(val);
			responseDtos.add(responseDto);
		});	
		return responseDtos;
	}
	
	public AccountFindByAgencyAndAccountResponseDto findByAgencyAndAccount(AccountFindByAgencyAndAccountRequestDto requestDto) {
		var account = accountRepository.findByAgencyAgencyAndAccount(requestDto.getAgencyAgency(), requestDto.getAccount()).orElseThrow(() -> {
			throw new EntityNotFoundException("Agency and account not found");
		});
		var responseDto = new AccountFindByAgencyAndAccountResponseDto(account);
		return responseDto;
	}
	
	public AccountTransferBalanceResponseDto transferBalance(String id1, String id2, AccountTransferBalanceRequestDto requestDto) {
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
        var responseDto = new AccountTransferBalanceResponseDto(account1);
        return responseDto;
	}
}
