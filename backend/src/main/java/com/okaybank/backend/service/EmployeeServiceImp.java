package com.okaybank.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.dto.EmployeeResponseDTO;
import com.okaybank.backend.exception.ApplicationException;
import com.okaybank.backend.mapper.EmployeeMapper;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.model.Employee;
import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;
import com.okaybank.backend.repository.EmployeeRepository;
import com.okaybank.backend.specification.EmployeeSpecification;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final AgencyService agencyService;

	public EmployeeServiceImp(EmployeeRepository employeeRepository, AgencyService agencyService) {
		this.employeeRepository = employeeRepository;
		this.agencyService = agencyService;
	}

	@Transactional
	public EmployeeResponseDTO registerEmployee(EmployeeRequestDTO dto) {
		Employee employee = EmployeeMapper.toEmployee(dto);

		validateEmployee(employee);

		Agency agencyFound = agencyService.findByNumber(dto.getAgencyNumber());

		employee.setAgency(agencyFound);

		Employee employeeSaved = employeeRepository.save(employee);

		return EmployeeMapper.toEmployeeResponseDTO(employeeSaved);
	}

	public Page<EmployeeResponseDTO> listEmployees(EmployeeType employeeType, EmployeeStatus employeeStatus,
			Pageable pageable) {
		return employeeRepository.findAll(EmployeeSpecification.filter(employeeType, employeeStatus), pageable)
				.map(EmployeeMapper::toEmployeeResponseDTO);
	}

	private void validateEmployee(Employee employee) {
		if (employee.getJourney() == 0) {
			throw new ApplicationException("Jornada não deve ser 0.");
		}

		if (employee.getSalary().scale() != 2) {
			throw new ApplicationException("Salário deve ter 2 dígitos.");
		}

		if (employee.getSalary().toString().equals("0.00")) {
			throw new ApplicationException("Salário não deve ser 0.00.");
		}

		if (employeeRepository.existsByMatriculationOrCpfOrNameOrEmailOrPhone(employee.getMatriculation(),
				employee.getCpf(), employee.getName(), employee.getEmail(), employee.getPhone())) {
			throw new ApplicationException("Matricula, CPF, nome, email ou telefone não deve ser repetida.");
		}
	}
}
