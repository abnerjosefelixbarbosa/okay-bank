package com.okay_bank.backend.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {
	private String name;
	private String document;
	private String institution;
	private String accountNumber;
	private String agencyNumber;
}
