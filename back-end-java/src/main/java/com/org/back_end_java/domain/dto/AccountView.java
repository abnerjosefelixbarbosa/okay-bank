package com.org.back_end_java.domain.dto;

import java.math.BigDecimal;

import com.org.back_end_java.domain.entity.TypeAccount;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AccountView {
	private String id;
	private String number;
	private BigDecimal balance;
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	private String password;
	private CustomerView customer;
	private AgencyView agency;
	private CardView card;
}
