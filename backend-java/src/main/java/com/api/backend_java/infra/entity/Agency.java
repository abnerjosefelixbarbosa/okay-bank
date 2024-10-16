package com.api.backend_java.infra.entity;

import java.io.Serializable;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private String id;
	@Column(nullable = false, unique = true)
	private String number;
	
	public Agency(CreateAccountDTO dto) {
		this.id = dto.getAgencyId();
	}

	public Agency(CreateAgencyDTO dto) {
		this.id = UlidCreator.getUlid().toString();
		this.number = dto.getNumber();
	}
}
