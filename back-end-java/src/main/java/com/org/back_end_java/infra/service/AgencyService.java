package com.org.back_end_java.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.back_end_java.infra.entity.Agency;
import com.org.back_end_java.infra.repository.IAgencyRepository;

@Service
public class AgencyService implements IAgencyService {
	@Autowired
	private IAgencyRepository agencyRepository;
	
	public Agency save(Agency agency) {
		return agencyRepository.save(agency);
	}
	
	public boolean existsAgency(Agency agency) {
		return agencyRepository.existsByNumber(agency.getNumber());
	}
}
