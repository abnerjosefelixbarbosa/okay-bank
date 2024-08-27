package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	@Column(nullable = false, unique = true, length = 10)
	private String rg;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	@Column(nullable = false, unique = true, length = 20)
	private String contact;
	@Column(nullable = false, unique = true, length = 8)
	private String password;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Embedded
	private AddressDB address;
}