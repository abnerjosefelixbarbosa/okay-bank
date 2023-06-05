package com.org.apibancookay.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.org.apibancookay.models.Customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"agency", "account", "balance", "password", "customer"})
public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String agency;
	private String account;
	private BigDecimal balance;
	private String password;
	private Customer customer;
}
