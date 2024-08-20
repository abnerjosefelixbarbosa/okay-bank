package com.org.back_end_java.infra.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "debit_card_tb")
public class DebitCard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false)
	private Date expirationDate;
	@Column(nullable = false, unique = true)
	private String cvv;
	@OneToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
}
