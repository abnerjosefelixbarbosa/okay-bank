package com.api.backend_java.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
	SAVINGS("SAVINGS"), CURRENT("CURRENT"), INCOME("INCOME"), SALARY("SALARY");

	private String value;
}