package com.okaybank.backend.service.imp;

import org.springframework.stereotype.Service;

import com.okaybank.backend.dto.request.AgencyRequestDTO;
import com.okaybank.backend.dto.response.AgencyResponseDTO;
import com.okaybank.backend.exception.ApplicationException;
import com.okaybank.backend.mapper.AgencyMapper;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.repository.AgencyRepository;
import com.okaybank.backend.service.AgencyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgencyServiceImp implements AgencyService {
	private final AgencyRepository agencyRepository;

	public AgencyResponseDTO registerAgency(AgencyRequestDTO request) {
		Agency agency = AgencyMapper.toAgency(request);
		
		validateAgency(agency);
		
		Agency agencySaved = agencyRepository.save(agency);
		
		AgencyResponseDTO response = AgencyMapper.toAgencyResponseDTO(agencySaved);
		
		return response;
	}
	
	private void validateAgency(Agency agency) {
		boolean isExistsNumber = agencyRepository.existsByNumber(agency.getNumber());
		
		if (isExistsNumber) {
			throw new ApplicationException("Numero não deve ser repetido.");
		}
	}
}
