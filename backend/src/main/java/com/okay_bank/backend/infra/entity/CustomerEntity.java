package com.okay_bank.backend.infra.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "customer_tb")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "document", length = 14, nullable = false, unique = true)
	private String document;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	@Column(name = "email", length = 30, nullable = false, unique = true)
	private String email;
	@Embedded
	private AddressEntity address;
	@Column(name = "phone", length = 30, nullable = false, unique = true)
	private String phone;
	@Column(name = "customer_type", nullable = false)
	private CustomerTypeEntity customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<AccountEntity> accounts;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<CardEntity> cards; 
}
