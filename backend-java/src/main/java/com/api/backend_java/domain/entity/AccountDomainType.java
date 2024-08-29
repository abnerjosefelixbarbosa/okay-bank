package com.api.backend_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountDomainType {
	SAVINGS("SAVINGS"), CURRENT("CURRENT"), INCOME("INCOME"), SALARY("SALARY");

	private String value;
}
