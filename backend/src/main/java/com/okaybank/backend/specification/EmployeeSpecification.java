package com.okaybank.backend.specification;

import org.springframework.data.jpa.domain.Specification;

import com.okaybank.backend.model.Employee;
import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;

public class EmployeeSpecification {
	private static Specification<Employee> byEmployeeType(EmployeeType employeeType) {
		return (root, query, builder) -> {
			if (employeeType == null) {
				return null;
			}

			return builder.equal(root.get("employeeType"), employeeType);
		};
	}

	private static Specification<Employee> byEmployeeStatus(EmployeeStatus employeeStatus) {
		return (root, query, builder) -> {
			if (employeeStatus == null) {
				return null;
			}

			return builder.equal(root.get("employeeStatus"), employeeStatus);
		};
	}

	public static Specification<Employee> filter(EmployeeType employeeType, EmployeeStatus employeeStatus) {
		return Specification.where(byEmployeeType(employeeType)).and(byEmployeeStatus(employeeStatus));
	}
}
