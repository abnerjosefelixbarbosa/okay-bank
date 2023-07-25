package com.org.backend.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.org.backend.models.dtos.AccountFindByAgencyAndAccountResponseDto;
import com.org.backend.models.dtos.AccountGetAllByCustomerIdResponseDto;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;
import com.org.backend.models.dtos.AccountTransferBalanceResponseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String account;
	@Column(nullable = false, unique = true, length = 4)
	private String password;
	@Column(nullable = false, scale = 2)
	private BigDecimal balance;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public void withdraw(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}
	
	public AccountGetByIdResponseDto convertAccountGetByIdResponseDto() {
		var responseDto = new AccountGetByIdResponseDto();
		responseDto.setIdAccount(id);
		responseDto.setAgency(agency.getAgency());
		responseDto.setAccount(account);
		responseDto.setBalance(balance);
		responseDto.setNameCustomer(customer.getName());
		return responseDto;
	}
	
	public List<AccountGetAllByCustomerIdResponseDto> convertAccountGetAllByCustomerIdResponseDto(List<Account> accounts) {
		var responseDtos = new LinkedList<AccountGetAllByCustomerIdResponseDto>();
		var responseDto = new AccountGetAllByCustomerIdResponseDto();
		accounts.stream().forEach((val) -> {
			responseDto.setId(val.getId());
			responseDto.setAgency(val.getAgency().getAgency());
			responseDto.setAccount(val.getAccount());
			responseDtos.add(responseDto);
		});	
		return responseDtos;
	}
	
	public AccountFindByAgencyAndAccountResponseDto convertAccountFindByAgencyAndAccountResponseDto() {
		var responseDto = new AccountFindByAgencyAndAccountResponseDto();
		responseDto.setId(id);
		return responseDto;
	}
	
	public AccountTransferBalanceResponseDto convertAccountTransferBalanceResponseDto() {
		var responseDto = new AccountTransferBalanceResponseDto();
		responseDto.setId(id);
		return responseDto;
	}
}
