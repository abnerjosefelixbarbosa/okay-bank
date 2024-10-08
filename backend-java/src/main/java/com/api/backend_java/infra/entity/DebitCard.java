package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "debitcard_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false)
	private LocalDate expirationDate;
	@Column(nullable = false, unique = true)
	private String cvv;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
}
