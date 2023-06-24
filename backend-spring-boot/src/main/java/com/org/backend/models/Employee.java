package com.org.backend.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"customers", "accounts", "agencies"})
@EqualsAndHashCode(exclude = {"customers", "accounts", "agencies"})
@Entity
@Table(name = "employee")
@JsonIgnoreProperties({ "customers", "accounts", "agencies" })
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, precision = 10, scale = 0)
	private BigDecimal matriculation;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, scale = 2)
	private BigDecimal salary;
	@ManyToOne
	@JoinColumn(name = "position_id", nullable = false)
	private Position position;
	@OneToMany(mappedBy = "employee")
	private List<Customer> customers;
	@OneToMany(mappedBy = "employee")
	private List<Account> accounts;
	@OneToMany(mappedBy = "employee")
	private List<Agency> agencies;
}
