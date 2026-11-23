package com.okay_bank.backend.infra.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.okay_bank.backend.application.entity.Agency;
import com.okay_bank.backend.application.exception.NotFoundException;
import com.okay_bank.backend.application.gateway.AgencyGateway;
import com.okay_bank.backend.infra.entity.AgencyEntity;
import com.okay_bank.backend.infra.mapper.AgencyMapper;
import com.okay_bank.backend.infra.repository.AgencyRepository;

@Component
public class AgencyService implements AgencyGateway {
	private final AgencyRepository agencyRepository;

	public AgencyService(AgencyRepository agencyRepository) {
		this.agencyRepository = agencyRepository;
	}

	public Agency registerAgency(Agency agency) {
		AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(agency);
		
		AgencyEntity savedAgency = agencyRepository.save(agencyEntity);
		
		return AgencyMapper.toAgency(savedAgency);
	}
	
	public Agency updateAgency(String id, Agency agency) {
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(agency);
        
        AgencyEntity foundAgency = agencyRepository
				.findById(id).orElseThrow(() -> new NotFoundException("Id deve ser existente."));
        
        BeanUtils.copyProperties(agencyEntity, foundAgency, "id");
		
		AgencyEntity savedAgency = agencyRepository.save(foundAgency);
		
		return AgencyMapper.toAgency(savedAgency);
	}
	
	public boolean isExistsNumber(Agency agency) {
		return agencyRepository.existsByNumber(agency.getNumber());
	}
}
