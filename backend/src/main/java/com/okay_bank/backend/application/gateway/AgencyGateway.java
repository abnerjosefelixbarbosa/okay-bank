package com.okay_bank.backend.application.gateway;

import com.okay_bank.backend.application.entity.Agency;

public interface AgencyGateway {
	Agency registerAgency(Agency agency);
	
	Agency updateAgency(String id, Agency agency);

	boolean isExistsNumber(Agency agency);

	Agency findAgencyById(String id);
}
