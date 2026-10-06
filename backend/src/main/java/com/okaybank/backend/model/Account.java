package com.okaybank.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account_tb")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 20, nullable = false, unique = true)
	private String number;
	@Column(precision = 30, scale = 2, nullable = false)
	private BigDecimal balance;
	@Column(nullable = false)
	private LocalDate creationDate;
	@Column(nullable = false, unique = true)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private AccountType accountType;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<AccountTransfer> accountTransfers;
}
