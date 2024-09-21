package com.api.backend_java.domain.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Agency;
import com.api.backend_java.domain.entity.Customer;

@Component
public class AccountDomainMapper {
	public Account toAccount(CreateAccountDTO dto) {
		Customer customer = new Customer();
		customer.setId(dto.getCustomerId());

		Agency agency = new Agency();
		agency.setId(dto.getAgencyId());

		Account account = new Account();
		account.setNumber(dto.getNumber());
		account.setBalance(BigDecimal.ZERO);
		account.setAccountType(dto.getAccountType());
		account.setPassword(dto.getPassword());
		account.setCustomer(customer);
		account.setAgency(agency);

		return account;
	}
}