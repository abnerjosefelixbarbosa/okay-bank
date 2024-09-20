package com.api.backend_java.domain.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Agency;
import com.api.backend_java.domain.entity.Customer;

@Component
public class AccountDomainMapper {
	public Account toAccount(CreateAccountDTO dto) {
		Customer customer = new Customer();
		customer.setId(dto.customerId());

		Agency agency = new Agency();
		agency.setId(dto.agencyId());

		return new Account(
				null,
				dto.number(),
				dto.balance(),
				dto.accountType(),
				dto.password(),
				customer,
				agency
		);
	}
}