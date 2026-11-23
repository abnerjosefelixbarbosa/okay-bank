package com.okay_bank.backend.application.usercase;

import com.okay_bank.backend.application.entity.Agency;

public interface AgencyUserCase {
	Agency registerAgency(Agency agency);

	Agency updateAgency(String id, Agency agency);
}
