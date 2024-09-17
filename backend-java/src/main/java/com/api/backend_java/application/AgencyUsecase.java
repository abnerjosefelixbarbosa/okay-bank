package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.domain.usercase.IAgencyUsercase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AgencyUsecase implements IAgencyUsercase {
	private IAgencyGateway agencyGateway;
	
	public AgencyDTO create(CreateAgencyDTO dto) {
		return agencyGateway.create(dto);
	}
}
