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
	
	public void getById(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();
		this.password = account.getPassword();
		this.balance = account.getBalance();
		this.agency = new AgencyDto();
		this.agency.setAgency(account.getAgency().getAgency());
		this.customer = new CustomerDto();
		this.customer.setName(account.getCustomer().getName());
	}
	
	public void getAllByCustomerId(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();
		this.agency = new AgencyDto();
		this.agency.setAgency(account.getAgency().getAgency());
	}
	
	public void findByAgencyAndAccount(Account account) {
		this.id = account.getId();
	}
	
	public void transferBalance(Account account) {
		this.id = account.getId();
	}
}
