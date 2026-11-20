package com.okay_bank.backend.infra.dto.response;

import java.time.LocalDate;

public record AgencyResponseDTO(
		String id,
		String number,
		LocalDate creationDate
) {}
