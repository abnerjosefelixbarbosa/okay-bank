package com.org.back_end_java.domain.entity;

import java.util.Date;

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
	private Address address;
}
