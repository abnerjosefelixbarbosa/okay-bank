package com.org.backend.models.dtos;

import com.org.backend.models.entities.Agency;

import lombok.Data;

@Data
public class AgencyDto {
	private String id;
	private String agency;
	private EmployeeDto employee;
	
	public AgencyDto(Agency agency) {
		this.id = agency.getId();
		this.agency = agency.getAgency();
		this.employee = new EmployeeDto(agency.getEmployee());
	}
}
