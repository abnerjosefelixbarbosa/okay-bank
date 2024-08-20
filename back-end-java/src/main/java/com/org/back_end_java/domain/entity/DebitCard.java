package com.org.back_end_java.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class DebitCard {
	private String id;
	private String number;
	private Date expirationDate;
	private String cvv;
	private Account account;
}
