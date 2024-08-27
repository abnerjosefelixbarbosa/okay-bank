package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;
import com.api.backend_java.domain.usercase.IAgencyUserCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AgencyUseCase implements IAgencyUserCase {
	private IAgencyGateway agencyGateway;
	
	public AgencyView create(AgencyDTO dto) {
		return agencyGateway.create(dto);
	}
}
