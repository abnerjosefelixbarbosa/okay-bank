package com.okay_bank.backend.application.usercase.imp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	
	public Agency updateAgency(String id, Agency agency) {
		validateAgency(agency);
		
		return agencyGateway.updateAgency(id, agency);
	}
	
	public Agency findAgencyById(String id) {
		return agencyGateway.findAgencyById(id);
	}
	
	public Page<Agency> listAgencies(String number, Pageable pageable) {
		return agencyGateway.listAgencies(number, pageable);
	}
	
	private void validateAgency(Agency agency) {
		if (agencyGateway.isExistsNumber(agency)) {
			throw new ApplicationException("O número não deve ser repetido.");
		}
	}
}
