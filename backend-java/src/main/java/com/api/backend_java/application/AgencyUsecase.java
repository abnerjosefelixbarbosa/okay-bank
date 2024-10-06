package com.api.backend_java.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.domain.usercase.IAgencyUsercase;

@Component
public class AgencyUsecase implements IAgencyUsercase {
	@Autowired
	private IAgencyGateway agencyGateway;
	
	public AgencyDTO create(CreateAgencyDTO dto) {
		return agencyGateway.create(dto);
	}
}
