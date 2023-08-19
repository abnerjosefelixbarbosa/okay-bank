package com.org.backend.models.dtos;

import com.org.backend.models.entities.Agency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
