package com.okaybank.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.okaybank.backend.model.enums.CardType;

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
	@Column(name = "id")
	private String id;
	@Column(name = "number", length = 16, nullable = false, unique = true)
	private String number;
	@Column(name = "holder", length = 100, nullable = false)
	private String holder;
	@Column(name = "validation_date", nullable = false)
	private LocalDate validationDate;
	@Column(name = "flag", length = 20, nullable = false)
	private String flag;
	@Column(name = "cvv", length = 3, nullable = false, unique = true)
	private String cvv;
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "card_type", nullable = false)
	private CardType cardType;
	@Column(name = "limit", precision = 30, scale = 2)
	private BigDecimal limit;
	@Column(name = "agency", length = 20)
	private String agency;
	@Column(name = "account", length = 20)
	private String account;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
}
