package com.api.backend_java.domain.entity;

import com.api.backend_java.domain.dto.CreateAccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
	private String id;
	private String number;
	
	public Agency(CreateAccountDTO dto) {
		this.id = dto.getAgencyId();
	}
}
