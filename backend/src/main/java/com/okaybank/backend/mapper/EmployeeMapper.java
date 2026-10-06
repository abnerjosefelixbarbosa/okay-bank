package com.okaybank.backend.mapper;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;
import com.okaybank.backend.model.Address;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.model.Employee;

public class EmployeeMapper {
	public static Employee toEmployee(EmployeeRequestDTO dto) {
		Agency agency = new Agency(null, dto.getAgencyNumber(), null, null, null);

		Address address = new Address(dto.getPostalCode(), dto.getAddressName(), dto.getNumber(), dto.getDistrict(),
				dto.getCity(), dto.getState());

		Employee employee = new Employee(null, dto.getMatriculation(), dto.getBirthDate(), dto.getCpf(), dto.getName(),
				dto.getSalary(), dto.getEmail(), dto.getPhone(), dto.getJourney(), dto.getEmployeeType(),
				dto.getEmployeeStatus(), address, agency);

		return employee;
	}

	public static EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
		EmployeeResponseDTO response = new EmployeeResponseDTO(employee.getId(), employee.getMatriculation(),
				employee.getBirthDate(), employee.getCpf(), employee.getName(), employee.getSalary(),
				employee.getEmail(), employee.getPhone(), employee.getJourney(), employee.getEmployeeType(),
				employee.getEmployeeStatus(), employee.getAddress().getPostalCode(), employee.getAddress().getCity(),
				employee.getAddress().getNumber(), employee.getAddress().getDistrict(), employee.getAddress().getCity(),
				employee.getAddress().getState());

		return response;
	}
}
