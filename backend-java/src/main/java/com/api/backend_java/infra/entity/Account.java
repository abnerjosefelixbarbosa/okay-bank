package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.api.backend_java.domain.dto.AccountDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String number;
	@Column(nullable = false)
	private BigDecimal balance;
	@Column(nullable = false, unique = true, length = 6)
	private String password;
	@Column(nullable = false)
	private AccountType accountType;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false, unique = true)
	private Agency agency;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, unique = true)
	private Customer customer;

	public Account(AccountDTO dto) {
		number = dto.number();
		balance = BigDecimal.ZERO;
		password = dto.password();
		accountType = AccountType.valueOf(dto.accountType().getValue());
		agency = new Agency(dto);
		customer = new Customer(dto);
	}
}
