package com.okaybank.backend.service;

import com.okaybank.backend.dto.request.AgencyRequestDTO;
import com.okaybank.backend.dto.response.AgencyResponseDTO;

public interface AgencyService {
	AgencyResponseDTO registerAgency(AgencyRequestDTO request);
}
