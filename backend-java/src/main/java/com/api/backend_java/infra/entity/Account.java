package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false)
	private BigDecimal balance;
	@Column(nullable = false)
	private AccountType accountType;
	@Column(nullable = false, unique = true)
	private String password;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	
	public Account(CreateAccountDTO dto) {
		this.id = UlidCreator.getUlid().toString();
		this.number = dto.getNumber();
		this.balance = BigDecimal.ZERO;
		this.accountType = AccountType.valueOf(dto.getAccountType().getValue());
		this.password = dto.getPassword();
	}
}
