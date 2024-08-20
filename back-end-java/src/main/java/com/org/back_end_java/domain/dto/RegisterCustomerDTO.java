package com.org.back_end_java.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.org.back_end_java.domain.entity.AccountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RegisterCustomerDTO {
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private String customerContact;
	private String customerCpf;
	private String customerRg;
	private Date customerBirthDate;
	
	private String addressPostalCode;
	private String addressNumber;
	private String addressName;
	private String addressDistrict;
	private String addressCity;
	private String addressState;
	
	private String accountNumber;
	private BigDecimal accountBalance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private String accountPassword;
	
	private String agencyNumber;
}