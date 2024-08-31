package com.api.backend_java.infra.entity;

import java.io.Serializable;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AgencyDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agency_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String number;
	
	public Agency(AgencyDTO dto) {
		number = dto.number();
	}

	public Agency(AccountDTO dto) {
		number = dto.agencyNumber();
	}
}
