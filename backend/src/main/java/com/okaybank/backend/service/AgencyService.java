package com.okaybank.backend.service;

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.dto.AgencyResponseDTO;
import com.okaybank.backend.model.Agency;

public interface AgencyService {
	AgencyResponseDTO registerAgency(AgencyRequestDTO dto);

	AgencyResponseDTO updateAgency(String id, AgencyRequestDTO dto);

	Agency findByNumber(String number);
}
