package com.org.back_end_java.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_account")
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
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	@Column(nullable = false, unique = true)
	private String password;
	@ManyToOne
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "id_agency", nullable = false)
	private Agency agency;
	@OneToOne(mappedBy = "account")
	private Card card;
}
