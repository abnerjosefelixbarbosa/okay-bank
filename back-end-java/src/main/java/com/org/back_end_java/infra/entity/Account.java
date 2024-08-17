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
	@Column(nullable = false, unique = true, length = 10)
	private String number;
	@Column(nullable = false, scale = 2)
	private BigDecimal balance;
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private TypeAccount typeAccount;
	@Column(nullable = false, unique = true, length = 6)
	private String password;
}
