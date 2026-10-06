package com.okaybank.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.dto.AgencyResponseDTO;
import com.okaybank.backend.exception.ApplicationException;
import com.okaybank.backend.exception.NotFoundException;
import com.okaybank.backend.mapper.AgencyMapper;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.repository.AgencyRepository;

import jakarta.transaction.Transactional;

@Service
public class AgencyServiceImp implements AgencyService {
	@Autowired
	private AgencyRepository agencyRepository;

	@Transactional
	public AgencyResponseDTO registerAgency(AgencyRequestDTO dto) {
		Agency agency = AgencyMapper.toAgency(dto);

		validateAgency(agency);

		Agency agencySaved = agencyRepository.save(agency);

		return AgencyMapper.toAgencyResponseDTO(agencySaved);
	}

	@Transactional
	public AgencyResponseDTO updateAgency(String id, AgencyRequestDTO dto) {
		Agency agency = AgencyMapper.toAgency(dto);

		validateAgency(agency);

		Agency agencyFound = agencyRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id deve ser existente."));

		BeanUtils.copyProperties(agency, agencyFound, "id");

		Agency agencySaved = agencyRepository.save(agencyFound);

		return AgencyMapper.toAgencyResponseDTO(agencySaved);
	}

	private void validateAgency(Agency agency) {
		if (agencyRepository.existsByNumber(agency.getNumber())) {
			throw new ApplicationException("Numero não deve ser repetido.");
		}
	}
}
