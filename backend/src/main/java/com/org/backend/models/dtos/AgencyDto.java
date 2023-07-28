package com.org.backend.models.dtos;

import lombok.Data;

@Data
public class AgencyDto {
	private String id;
	private String agency;
	private EmployeeDto employee;
}
