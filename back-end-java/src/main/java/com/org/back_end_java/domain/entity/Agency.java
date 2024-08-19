package com.org.back_end_java.domain.entity;

import java.util.Collection;

import lombok.Data;

@Data
public class Agency {
	private String id;
	private String number;
	private Collection<Account> accounts;
}
