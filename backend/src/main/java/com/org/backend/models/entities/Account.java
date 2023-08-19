package com.org.backend.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.org.backend.models.dtos.AccountDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"employee", "agency", "customer"})
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@EqualsAndHashCode.Include
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	@EqualsAndHashCode.Include
	private String account;
	@Column(nullable = false, unique = true, length = 4)
	@EqualsAndHashCode.Include
	private String password;
	@Column(nullable = false, scale = 2)
	private BigDecimal balance;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	public Account(AccountDto dto) {
		this.id = dto.getId();
		this.account = dto.getAccount();
		this.password = dto.getPassword();
		this.balance = dto.getBalance();
		this.employee = new Employee(dto.getEmployee());
		this.agency = new Agency(dto.getAgency());
		this.customer = new Customer(dto.getCustomer());
	}

	public void deposit(BigDecimal value) {
		this.balance = this.balance.add(value);
	}

	public void withdraw(BigDecimal value) {
		this.balance = this.balance.subtract(value);
	}
}
