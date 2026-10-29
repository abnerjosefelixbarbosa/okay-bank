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
	@Column(name = "id")
	private String id;
	@Column(name = "document", length = 20, nullable = false, unique = true)
	private String document;
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	@Column(name = "email", length = 30, nullable = false, unique = true)
	private String email;
	@Embedded
	private Address address;
	@Column(name = "phone", length = 30, nullable = false, unique = true)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(name = "customer_type", nullable = true)
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Account> accounts;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Card> cards; 
}
