package com.org.backend.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(nullable = false, unique = true, length = 20)
	private String rg;
	@Column(nullable = false, unique = true, length = 6)
	private String password;
	@Column(nullable = false, unique = true, length = 20)
	private String telephone;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date birthDate;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false)
	private Integer addressNumber;
	@Column(nullable = false, length = 20)
	private String addressZipCode;
	@Column(nullable = false, length = 50)
	private String address;
	@Column(nullable = false, length = 30)
	private String addressDistrict;
	@Column(nullable = false, length = 30)
	private String addressCity;
	@Column(nullable = false, length = 2)
	private String addressState;
}
