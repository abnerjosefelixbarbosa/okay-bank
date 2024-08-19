package com.org.back_end_java.domain.dto;

import lombok.Data;

@Data
public class RecipientView {
	private String id;
	private String name;
	private String agency;
	private String account;
	private String bank;
}
