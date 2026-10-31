package com.okaybank.backend.dto.response;

import java.time.LocalDate;

import com.okaybank.backend.model.Agency;

public record AgencyResponseDTO(
		String id,
		String number,
		LocalDate creationDate
) {
	public AgencyResponseDTO(Agency agency) {
		this(agency.getId(), agency.getNumber(), agency.getCreationDate());
	}
}
