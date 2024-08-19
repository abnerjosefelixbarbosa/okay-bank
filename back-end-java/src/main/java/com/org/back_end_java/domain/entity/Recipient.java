package com.org.back_end_java.domain.entity;

import lombok.Data;

@Data
public class Recipient {
	private String id;
	private String name;
	private String agency;
	private String account;
	private String bank;
}
