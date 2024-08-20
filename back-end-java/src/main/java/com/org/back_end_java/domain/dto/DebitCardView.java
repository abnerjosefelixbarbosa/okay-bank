package com.org.back_end_java.domain.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DebitCardView {
	private String id;
	private String number;
	private Date dateExpiration;
	private String cvv;
	private AccountView account;
}
