package com.okay_bank.backend.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_tb")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "number", length = 10, nullable = false, unique = true)
	private String number;
	@Column(name = "balance", scale = 2, nullable = false)
	private BigDecimal balance;
	@Column(name = "creation_date", nullable = false)
	private LocalDate creationDate;
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	@Column(name = "account_type", nullable = false)
	private AccountTypeEntity accountType;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private AgencyEntity agency;
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<AccountTransferEntity> accountTransfers;
}
