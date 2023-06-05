package com.org.apibancookay.models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "customer" })
@EqualsAndHashCode(exclude = { "agency", "account", "balance", "password", "customer" })
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Column(length = 20, nullable = false, unique = true)
	private String agency;
	@Column(length = 20, nullable = false, unique = true)
	private String account;
	@Column(scale = 2, nullable = false)
	private BigDecimal balance;
	@Column(length = 4, nullable = false, unique = true)
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, unique = true)
	private Customer customer;

	public void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public void withdraw(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}
}
