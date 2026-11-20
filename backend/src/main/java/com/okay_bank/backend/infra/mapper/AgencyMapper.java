package com.okay_bank.backend.infra.mapper;

import java.time.LocalDate;

import com.okay_bank.backend.application.entity.Agency;
import com.okay_bank.backend.infra.dto.request.AgencyRequestDTO;
import com.okay_bank.backend.infra.dto.response.AgencyResponseDTO;
import com.okay_bank.backend.infra.entity.AgencyEntity;

public class AgencyMapper {
	public static Agency toAgency(AgencyRequestDTO resquest) {
		return new Agency(
				null, 
				resquest.number(), 
				LocalDate.now(), 
				null, 
				null
		);
	}

	public static AgencyResponseDTO toAgencyResponseDTO(Agency agency) {
		return new AgencyResponseDTO(
				agency.getId(), 
				agency.getNumber(), 
				agency.getCreationDate()
		);
	}

	public static AgencyEntity toAgencyEntity(Agency agency) {
		return new AgencyEntity(
				agency.getId(), 
				agency.getNumber(), 
				agency.getCreationDate(), 
				null, 
				null
		);
	}

	public static Agency toAgency(AgencyEntity agencyEntity) {
		return new Agency(
				agencyEntity.getId(), 
				agencyEntity.getNumber(), 
				agencyEntity.getCreationDate(), 
				null, 
				null
		);
	}
}
