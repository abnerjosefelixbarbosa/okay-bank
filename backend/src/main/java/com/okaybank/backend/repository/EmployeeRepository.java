package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {
	boolean existsByMatriculation(String matriculation);
	boolean existsByCpf(String cpf);
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	boolean existsByPhone(String phone);
}
