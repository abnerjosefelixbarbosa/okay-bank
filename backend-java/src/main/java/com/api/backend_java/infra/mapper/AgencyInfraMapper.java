package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;
import com.api.backend_java.infra.entity.Agency;

@Component
public class AgencyInfraMapper {

	public AgencyView toAgencyView(Agency agency) {
		AgencyView view = new AgencyView(agency.getId(), agency.getNumber());
		return view;
	}
	
	public Agency toAgency(AgencyDTO dto) {
		Agency agency = new Agency(null, dto.number());
		return agency;
	}
}
