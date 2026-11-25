package com.okay_bank.backend.infra.specification;

import org.springframework.data.jpa.domain.Specification;

import com.okay_bank.backend.infra.entity.AgencyEntity;

public class AgencySpecification {
	private static Specification<AgencyEntity> byNumber(String number) {
		return (root, query, builder) -> {
			if (number == null) {
				return null;
			}

			return builder.like(root.get("number"), "%" + number + "%");
		};
	}
	
	public static Specification<AgencyEntity> filter(String number) {
		return Specification.where(byNumber(number));
	}
}
