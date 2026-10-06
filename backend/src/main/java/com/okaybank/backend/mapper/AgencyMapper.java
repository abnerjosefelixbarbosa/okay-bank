package com.okaybank.backend.mapper;

import java.time.LocalDate;

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.dto.AgencyResponseDTO;
import com.okaybank.backend.model.Agency;

public class AgencyMapper {
	public static Agency toAgency(AgencyRequestDTO dto) {
		Agency agency = new Agency(null, dto.getNumber(), LocalDate.now(), null, null);

		return agency;
	}

	public static AgencyResponseDTO toAgencyResponseDTO(Agency agency) {
		AgencyResponseDTO response = new AgencyResponseDTO(agency.getId(), agency.getNumber(),
				agency.getCreationDate());

		return response;
	}
}
