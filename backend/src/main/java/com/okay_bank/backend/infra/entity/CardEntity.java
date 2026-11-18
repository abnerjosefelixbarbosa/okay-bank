package com.okay_bank.backend.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card_tb")
public class CardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "number", length = 20, nullable = false, unique = true)
	private String number;
	@Column(name = "holder", length = 100, nullable = false)
	private String holder;
	@Column(name = "validation_date", nullable = false)
	private LocalDate validationDate;
	@Column(name = "flag", length = 30, nullable = false)
	private String flag;
	@Column(name = "cvv", length = 10, nullable = false, unique = true)
	private String cvv;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "card_type", nullable = false)
	private CardTypeEntity cardType;
	@Column(name = "card_limit", nullable = false)
	private BigDecimal limit;
	@Column(name = "agency", length = 10, nullable = false)
	private String agency;
	@Column(name = "account", length = 10, nullable = false)
	private String account;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;
}
