package com.api.backend_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {
	private String id;
	private String name;
	private String account;
	private String agency;
	private String bank;
}
