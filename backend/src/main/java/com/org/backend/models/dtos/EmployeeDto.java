package com.org.backend.models.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EmployeeDto {
	private String id;
	private BigDecimal matriculation;
	private String name;
	private BigDecimal salary;
	private PositionDto position;
}
