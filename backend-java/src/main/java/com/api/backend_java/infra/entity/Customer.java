package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Customer implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String password;
	@Column(nullable = false, unique = true)
	private String contact;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String rg;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(nullable = false)
	private String addressPostalCode;
	@Column(nullable = false)
	private String addressNumber;
	@Column(nullable = false)
	private String addressName;
	@Column(nullable = false)
	private String addressDistrict;
	@Column(nullable = false)
	private String addressCity;
	@Column(nullable = false)
	private String addressState;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_BASIC"));
	}
	
	public String getUsername() {
		return cpf;
	}
}