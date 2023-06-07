package com.org.backend.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = {"accountModels"})
@ToString(exclude = {"accountModels"})
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"accountModels"})
public class CustomerModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(nullable = false, unique = true, length = 20)
	private String rg;
	@Column(nullable = false, unique = true, length = 6)
	private String password;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@Column(nullable = false, unique = true, length = 20)
	private String telephone;	
	@Column(nullable = false)
	private LocalDate birthDate;	
	@Column(nullable = false)
	private Integer addressNumber;
	@Column(nullable = false, length = 20)
	private String addressZipCode;
	@Column(nullable = false, length = 50)
	private String addressName;
	@Column(nullable = false, length = 30)
	private String addressNeighborhood;
	@Column(nullable = false, length = 30)
	private String addressCity;
	@Column(nullable = false, length = 2)
	private String addressState;
	@OneToMany(mappedBy = "customerModel")
	private List<AccountModel> accountModels;
}
