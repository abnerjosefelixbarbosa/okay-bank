package com.org.back_end_java.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Card {
	private String id;
	private String number;
	private Date dateExpiration;
	private String cvv;
	private Account account;
}
