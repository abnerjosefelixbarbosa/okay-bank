package com.org.back_end_java.domain.entity;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class Customer {
	private String id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String cpf;
	private String rg;
	private Date dateBirth;
	@Embedded
	private Address address;
	private Collection<Account> accounts;
	private Collection<Transference> transferences;
}
