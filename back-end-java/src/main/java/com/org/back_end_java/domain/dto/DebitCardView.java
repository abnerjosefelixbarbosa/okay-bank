package com.org.back_end_java.domain.dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class DebitCardView {
	private String id;
	private String number;
	@Temporal(TemporalType.DATE)
	private Date expirationDate;
	private String cvv;
	private AccountView account;
}
