package com.api.backend_java.infra.mapper;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.infra.entity.Agency;

@Component
public class AgencyInfraMapper {
	public Agency toAgency(CreateAgencyDTO dto) {
		Agency agency = new Agency();
		agency.setId(UlidCreator.getUlid().toString());
		agency.setNumber(dto.getNumber());

		return agency;
	}
	
	public AgencyDTO toAgencyDTO(Agency agency) {
		AgencyDTO agencyDTO = new AgencyDTO();
		agencyDTO.setId(agency.getId());
		agency.setNumber(agency.getNumber());

		return agencyDTO;
	}
}
