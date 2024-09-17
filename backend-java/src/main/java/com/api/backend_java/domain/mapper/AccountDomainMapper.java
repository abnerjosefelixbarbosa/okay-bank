package com.api.backend_java.domain.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Agency;
import com.api.backend_java.domain.entity.Customer;

@Component
public class AccountDomainMapper {
	public Account toAccount(CreateAccountDTO dto) {
		return new Account(
				null,
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