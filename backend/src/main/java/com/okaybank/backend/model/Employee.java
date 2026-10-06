package com.okaybank.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "employee_tb")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 10, nullable = false, unique = true)
	private String matriculation;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;
	@Column(length = 100, nullable = false, unique = true)
	private String name;
	@Column(precision = 30, scale = 2, nullable = false)
	private BigDecimal salary;
	@Column(length = 30, nullable = false, unique = true)
	private String email;
	@Column(length = 30, nullable = false, unique = true)
	private String phone;
	@Column(nullable = false)
	private Integer journey;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private EmployeeType employeeType;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private EmployeeStatus employeeStatus; 
	@Embedded
	private Address address;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
}
