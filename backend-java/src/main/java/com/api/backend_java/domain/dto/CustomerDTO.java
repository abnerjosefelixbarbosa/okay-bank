package com.api.backend_java.domain.dto;

import java.time.LocalDate;

public record CustomerDTO(
	    String id,
		String name,
		String email,
		String password,
		String contact,
		String cpf,
		String rg,
		LocalDate birthDate,
		String addressPostalCode,
		String addressNumber,
		String addressName,
		String addressDistrict,
		String addressCity,
		String addressState
) {
}