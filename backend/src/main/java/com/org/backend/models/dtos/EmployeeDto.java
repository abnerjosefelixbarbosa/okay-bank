package com.org.backend.models.dtos;

import java.math.BigDecimal;

import com.org.backend.models.entities.Employee;

import lombok.Data;

@Data
public class EmployeeDto {
	private String id;
	private BigDecimal matriculation;
	private String name;
	private BigDecimal salary;
	private PositionDto position;
	
	public EmployeeDto(Employee employee) {
		this.id = employee.getId();
		this.matriculation = employee.getMatriculation();
		this.name = employee.getName();
		this.salary = employee.getSalary();
		this.position = new PositionDto(employee.getPosition());
	}
}
