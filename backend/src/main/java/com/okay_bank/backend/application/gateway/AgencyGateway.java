package com.okay_bank.backend.application.gateway;

import com.okay_bank.backend.application.entity.Agency;

public interface AgencyGateway {
	Agency registerAgency(Agency agency);

	boolean isExistsNumber(Agency agency);
}
