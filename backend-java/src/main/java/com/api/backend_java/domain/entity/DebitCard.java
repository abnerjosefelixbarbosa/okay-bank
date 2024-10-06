package com.api.backend_java.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCard {
	private String id;
	private String number;
	private LocalDate expirationDate;
	private String cvv;
	private Account account;
}
