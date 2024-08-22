package com.org.back_end_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.infra.entity.Agency;

@Component
public class AgencyMapper {

	public Agency toAgency(RegisterCustomerDTO dto) {
		Agency agency = new Agency();
		agency.setNumber(dto.getAgencyNumber());
		
		return agency;
	}

}
