package com.org.backend.models.dtos;

import java.math.BigDecimal;

import com.org.backend.models.entities.Account;

import lombok.Data;

@Data
public class AccountDto {
	private String id;
	private String account;
	private String password;
	private BigDecimal balance;
	private EmployeeDto employee;
	private AgencyDto agency;
	private CustomerDto customer;
	
	public AccountDto(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();
		this.password = account.getPassword();
		this.balance = account.getBalance();
		this.employee = new EmployeeDto(account.getEmployee());
		this.agency = new AgencyDto(account.getAgency());
		this.customer = new CustomerDto(account.getCustomer());
	}
}
