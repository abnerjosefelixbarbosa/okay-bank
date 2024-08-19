package com.org.back_end_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeAccount {
	CURRENT("CURRENT"), SAVINGS("SAVINGS");
	
	private String name;
}