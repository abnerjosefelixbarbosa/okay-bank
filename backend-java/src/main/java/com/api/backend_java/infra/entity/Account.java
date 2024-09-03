package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
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
}
