package com.okaybank.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_tb")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 16, nullable = false, unique = true)
	private String number;
	@Column(length = 100, nullable = false)
	private String holder;
	@Column(nullable = false)
	private LocalDate validationDate;
	@Column(length = 20, nullable = false)
	private String flag;
	@Column(length = 3, nullable = false, unique = true)
	private String cvv;
	@Column(nullable = false, unique = true)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CardType cardType;
	@Column(precision = 30, scale = 2)
	private BigDecimal limit;
	@Column(length = 20)
	private String agency;
	@Column(length = 20)
	private String account;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
}
