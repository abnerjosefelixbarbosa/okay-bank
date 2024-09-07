package com.api.backend_java.domain.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Agency;
import com.api.backend_java.domain.entity.Customer;

@Component
public class AccountDomainMapper {
	public Account toAccount(AccountDTO dto) {
		return new Account(
				dto.id(),
				dto.number(),
				dto.balance(),
				dto.accountType(),
				dto.password(),
				new Customer(
						dto.customer().id()
				),
				new Agency(
						dto.agency().id()
			    )
		);
	}
}