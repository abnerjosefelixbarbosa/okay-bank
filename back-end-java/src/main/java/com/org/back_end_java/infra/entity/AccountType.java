package com.org.back_end_java.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {
	CURRENT("CURRENT"), SAVINGS("SAVINGS"), INCOME("INCOME"), SALARY("SALARY");
	
	private String name;
}
