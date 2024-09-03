package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.infra.entity.Agency;

@Component
public class AgencyInfraMapper {
	public Agency toAgency(AgencyDTO dto) {
		return new Agency(
				null,
				dto.number()
		);
	}
	
	public AgencyDTO toAgencyDTO(Agency agency) {
		return new AgencyDTO(
				agency.getId(), 
		        agency.getNumber()
		);
	}
}
