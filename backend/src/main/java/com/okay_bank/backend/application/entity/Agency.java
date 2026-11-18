package com.okay_bank.backend.application.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
	private String id;
	private String number;
	private LocalDate creationDate;
	private List<Account> accounts;
	private List<Employee> employees;
}
