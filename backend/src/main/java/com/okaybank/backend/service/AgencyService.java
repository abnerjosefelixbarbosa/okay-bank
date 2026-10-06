package com.okaybank.backend.service;

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.dto.AgencyResponseDTO;

public interface AgencyService {
	AgencyResponseDTO registerAgency(AgencyRequestDTO dto);

	AgencyResponseDTO updateAgency(String id, AgencyRequestDTO dto);
}
