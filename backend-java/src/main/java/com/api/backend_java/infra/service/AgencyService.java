package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.exception.NotFoundException;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.repository.IAgencyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgencyService implements IAgencyGateway {
	private IAgencyRepository agencyRepository;

	public AgencyView create(AgencyDTO dto) {
		Agency agency = new Agency(dto);
		validate(agency);
		agency = agencyRepository.save(agency);
		return new AgencyView(agency);
	}
	
	public Agency getByNumber(String number) {
		return agencyRepository.findByNumber(number)
				.orElseThrow(() -> new NotFoundException("agency number not found"));
	}
	
	private void validate(Agency agency) {
		boolean existsByNumber = agencyRepository.existsByNumber(agency.getNumber());
		if (existsByNumber)
			throw new InvalidDataException("number not must exists");
	}
}
