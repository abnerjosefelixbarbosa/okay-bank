package com.org.back_end_java.infra.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_customer")
@Data
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@Column(nullable = false, unique = true, length = 8)
	private String password;
	@Column(nullable = false, unique = true, length = 20)
	private String contact;
	@Column(nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(nullable = false, unique = true, length = 20)
	private String rg;
	@Column(nullable = false)
	private Date dateBirth;
	@Embedded
	private Address address;
}
