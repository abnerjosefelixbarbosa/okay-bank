package com.okaybank.backend.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_tb") 
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 20, nullable = false, unique = true)
	private String document;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(length = 100, nullable = false, unique = true)
	private String name;
	@Column(length = 30, nullable = false, unique = true)
	private String email;
	@Embedded
	private Address address;
	@Column(length = 30, nullable = false, unique = true)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Account> accounts;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Card> cards; 
}
