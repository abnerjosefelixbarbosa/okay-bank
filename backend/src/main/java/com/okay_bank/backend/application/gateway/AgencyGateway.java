package com.okay_bank.backend.application.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.okay_bank.backend.application.entity.Agency;

public interface AgencyGateway {
	Agency registerAgency(Agency agency);
	
	Agency updateAgency(String id, Agency agency);

	boolean isExistsNumber(Agency agency);

	Agency findAgencyById(String id);

	Page<Agency> listAgencies(String number, Pageable pageable);
}
