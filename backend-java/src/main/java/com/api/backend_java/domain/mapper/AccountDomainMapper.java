package com.api.backend_java.domain.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Agency;
import com.api.backend_java.domain.entity.Customer;

@Component
public class AccountDomainMapper {
	public Account toAccount(CreateAccountDTO dto) {
		Customer customer = new Customer(dto);

		Agency agency = new Agency(dto);

		Account account = new Account(dto);
		account.setCustomer(customer);
		account.setAgency(agency);

		return account;
	}
}