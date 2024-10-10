package com.api.backend_java.domain.dto;

import com.api.backend_java.infra.entity.Agency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyDTO {
	private String id;
	private String number;
	
	public AgencyDTO(Agency agency) {
		this.id = agency.getId();
		this.number = agency.getNumber();
	}
}