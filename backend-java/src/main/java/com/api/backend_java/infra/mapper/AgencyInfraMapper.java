package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.infra.entity.Agency;

@Component
public class AgencyInfraMapper {
	public Agency toAgency(CreateAgencyDTO dto) {
		Agency agency = new Agency(dto);

		return agency;
	}
	
	public AgencyDTO toAgencyDTO(Agency agency) {
		AgencyDTO agencyDTO = new AgencyDTO(agency);

		return agencyDTO;
	}
}
