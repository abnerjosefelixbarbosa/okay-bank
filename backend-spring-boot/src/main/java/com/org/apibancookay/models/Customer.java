package com.org.apibancookay.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "account", "address", "telephone" })
@EqualsAndHashCode(exclude = { "name", "cpf", "rg", "email", "password", "birthDate", "account", "address",
		"telephone" })
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Column(length = 100, nullable = false)
	private String name;
	@Column(length = 20, nullable = false, unique = true)
	private String cpf;
	@Column(length = 20, nullable = false, unique = true)
	private String rg;
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	@Column(length = 6, nullable = false, unique = true)
	private String password;
	@Column(nullable = false)
	private LocalDate birthDate;
	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private Account account;
	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private Address address;
	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private Telephone telephone;
}
