package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.github.f4b6a3.ulid.UlidCreator;

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
	
    public Customer(CreateCustomerDTO dto) {
    	this.id = UlidCreator.getUlid().toString();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.contact = dto.getContact();
		this.cpf = dto.getCpf();
		this.rg = dto.getRg();
		this.birthDate = dto.getBirthDate();
		this.addressPostalCode = dto.getAddressPostalCode();
		this.addressNumber = dto.getAddressNumber();
		this.addressName = dto.getAddressName();
		this.addressDistrict = dto.getAddressDistrict();
		this.addressCity = dto.getAddressCity();
		this.addressState = dto.getAddressState();
	}
    
    public Customer(LoginCustomerDTO dto) {
		this.password = dto.getPassword();
		this.cpf = dto.getCpf();
	}
    
    public Customer(CreateAccountDTO dto) {
		this.id = dto.getCustomerId();
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_BASIC"));
	}
	
	public String getUsername() {
		return cpf;
	}
}