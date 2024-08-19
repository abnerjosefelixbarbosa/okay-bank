package com.org.back_end_java.domain.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerView {
	private String id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String cpf;
	private String rg;
	private Date dateBirth;
	private AddressView address;
}
