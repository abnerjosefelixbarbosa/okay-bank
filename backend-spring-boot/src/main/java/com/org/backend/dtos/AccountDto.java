package com.org.backend.dtos;

import java.math.BigDecimal;

import com.org.backend.models.Account;
import com.org.backend.models.Agency;
import com.org.backend.models.Customer;
import com.org.backend.models.Employee;

import lombok.Data;

@Data
public class AccountDto {
	private String id;	
	private String account;	
	private String password;	
	private BigDecimal balance;	
	private Employee employee;	
	private Agency agency;
	private Customer customer;
	
	public void setListAllById(Account account) {
		this.id = account.getId();
		this.account = account.getAccount();
		this.password = account.getPassword();
		this.balance = account.getBalance();
		this.agency = account.getAgency();
		this.agency.setEmployee(null);
		this.customer = account.getCustomer();
		this.customer.setEmployee(null);
	}
}
