package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import com.api.backend_java.domain.entity.AccountType;
import com.api.backend_java.infra.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	private String id;
	private String number;
	private BigDecimal balance;
	private AccountType accountType;
	private String password;
	private CustomerDTO customer;
	private AgencyDTO agency;
	
	public AccountDTO(Account account) {
		this.id = account.getId();
		this.number = account.getNumber();
		this.balance = account.getBalance();
		this.accountType = AccountType.valueOf(account.getAccountType().getValue());
		this.password = account.getPassword();
		this.customer = new CustomerDTO(account.getCustomer());
		this.agency = new AgencyDTO(account.getAgency());
	}
}