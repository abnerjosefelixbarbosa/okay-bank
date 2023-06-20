package com.org.backend.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String account;
	@Column(nullable = false, unique = true, length = 4)
	private String password;
	@Column(nullable = false, scale = 2)
	private BigDecimal balance;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public void withdraw(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}
}
