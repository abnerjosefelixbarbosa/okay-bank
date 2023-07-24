package com.org.backend.models.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountGetByIdResponseDto {
	private String idAccount;
	private String account;
	private String agency;
	private BigDecimal balance;	
	private String nameCustomer;
}
