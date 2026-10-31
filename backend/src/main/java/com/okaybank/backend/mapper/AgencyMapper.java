package com.okaybank.backend.mapper;

import com.okaybank.backend.dto.request.AgencyRequestDTO;
import com.okaybank.backend.dto.response.AgencyResponseDTO;
import com.okaybank.backend.model.Agency;

public class AgencyMapper {
	public static Agency toAgency(AgencyRequestDTO request) {
		Agency agency = new Agency(request);
		
		return agency;
	}
	
	public static AgencyResponseDTO toAgencyResponseDTO(Agency agency) {
		AgencyResponseDTO response = new AgencyResponseDTO(agency);
		
		return response;
	}
}