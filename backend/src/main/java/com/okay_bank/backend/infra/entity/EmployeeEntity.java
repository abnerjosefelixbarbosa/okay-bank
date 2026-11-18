package com.okay_bank.backend.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_tb")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "matriculation", length = 10, nullable = false, unique = true)
	private String matriculation;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate; 
	@Column(name = "cpf", length = 14,  nullable = false, unique = true)
	private String cpf;
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	@Column(name = "salary", scale = 2, nullable = false)
	private BigDecimal salary;
	@Embedded
	private AddressEntity address;
	@Column(name = "email", length = 30, nullable = false, unique = true)
	private String email;
	@Column(name = "phone", length = 30, nullable = false, unique = true)
	private String phone;
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	@Column(name = "employee_type", nullable = false)
	private EmployeeTypeEntity employeeType;
	@Column(name = "employee_status", nullable = false)
	private EmployeeStatusEntity employeeStatus;
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private AgencyEntity agency;
}
