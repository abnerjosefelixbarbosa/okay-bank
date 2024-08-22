package com.org.back_end_java.infra.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.infra.entity.Account;
import com.org.back_end_java.infra.entity.AccountType;

@Component
public class AccountMapper {
	
	public Account toAccount(RegisterCustomerDTO dto) {
		Account account = new Account();
		account.setAccountType(AccountType.valueOf(dto.getAccountType().getName()));
		account.setBalance(BigDecimal.valueOf(0));
		account.setNumber(dto.getAccountNumber());
		account.setPassword(dto.getAccountPassword());
		
		return account;
	}
	
}
