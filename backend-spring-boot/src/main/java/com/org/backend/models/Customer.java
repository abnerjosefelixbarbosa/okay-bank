package com.org.backend.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"accounts"})
@EqualsAndHashCode(exclude = {"accounts"})
@Entity(name = "customer")
@JsonIgnoreProperties({"accounts"})
public class Customer {
	@Id
	@Column(length = 50, nullable = false)
	private String id;
	@Column(length = 100, nullable = false)
	private String name;
	@Column(length = 20, nullable = false, unique = true)
	private String cpf;
	@Column(length = 20, nullable = false, unique = true)
	private String rg;
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	@Column(length = 20, nullable = false, unique = true)
	private String telephone;
	@Column(length = 6, nullable = false, unique = true)
	private String password;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(nullable = false)
	private Integer addressNumber;
	@Column(length = 20, nullable = false)
	private String addressZipCode;
	@Column(length = 100, nullable = false)
	private String addressName;
	@Column(length = 20, nullable = false)
	private String addressNeighborhood;
	@Column(length = 20, nullable = false)
	private String addressCity;
	@Column(length = 2, nullable = false)
	private String addressState;
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
}
