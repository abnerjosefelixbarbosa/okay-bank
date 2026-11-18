package com.okay_bank.backend.application.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private String id;
	private String document;
	private LocalDate birthDate;
	private String name;
	private String email;
	private Address address;
	private String phone;
	private CustomerType customerType;
	private List<Account> accounts;
	private List<Card> cards; 
}
