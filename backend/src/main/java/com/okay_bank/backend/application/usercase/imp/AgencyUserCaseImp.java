package com.okay_bank.backend.application.usercase.imp;

import com.okay_bank.backend.application.entity.Agency;
import com.okay_bank.backend.application.exception.ApplicationException;
import com.okay_bank.backend.application.gateway.AgencyGateway;
import com.okay_bank.backend.application.usercase.AgencyUserCase;

public class AgencyUserCaseImp implements AgencyUserCase {
	private final AgencyGateway agencyGateway;

	public AgencyUserCaseImp(AgencyGateway agencyGateway) {
		this.agencyGateway = agencyGateway;
	}

	public Agency registerAgency(Agency agency) {
		validateAgency(agency);
		
		return agencyGateway.registerAgency(agency);
	}
	
	private void validateAgency(Agency agency) {
		if (agencyGateway.isExistsNumber(agency)) {
			throw new ApplicationException("Número da agência não deve ser repetido.");
		}
	}
}
