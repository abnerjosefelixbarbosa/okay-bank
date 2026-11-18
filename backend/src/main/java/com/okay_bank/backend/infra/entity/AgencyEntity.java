package com.okay_bank.backend.infra.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agency_tb")
public class AgencyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "number", length = 10, nullable = false, unique = true)
	private String number;
	@Column(name = "creation_date", nullable = false)
	private LocalDate creationDate;
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private List<AccountEntity> accounts;
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private List<EmployeeEntity> employees;
}
