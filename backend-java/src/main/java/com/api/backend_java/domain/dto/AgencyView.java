package com.api.backend_java.domain.dto;

import com.api.backend_java.infra.entity.Agency;

public record AgencyView(
		String id,
		String number
) {
	public AgencyView(Agency agency) {
		this(
				agency.getId(),
				agency.getNumber()
		);
	}
}