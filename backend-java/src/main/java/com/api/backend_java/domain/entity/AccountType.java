package com.api.backend_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
	SAVINGS("SAVINGS"), CURRENT("CURRENT");

	private String value;
}

