package com.org.backend.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerDto(
		UUID id,
		String name,
        String cpf,
        String rg,
        String password,
        String email,
        String telephone,
        LocalDate birthDate,
        Integer addressNumber,
        String addressZipCode,
		String addressName,
		String addressNeighborhood,
		String addressCity,
		String addressState
) {
}
