package com.okay_bank.backend.application.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	private String id;
	private String number;
	private String holder;
	private LocalDate validationDate;
	private String flag;
	private String cvv;
	private String password;
	private CardType cardType;
	private BigDecimal limit;
	private String agency;
	private String account;
	private Customer customer;
}
