package com.org.backend.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(length = 20, nullable = false, unique = true)
	private String agency;
	@Column(length = 20, nullable = false, unique = true)
	private String account;
	@Column(scale = 2, nullable = false)
	private BigDecimal balance;
	@Column(length = 4, nullable = false, unique = true)
	private String password;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
	private Customer customer;

	public void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public void withdraw(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}
}
