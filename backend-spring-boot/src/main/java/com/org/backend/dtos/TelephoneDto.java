package com.org.backend.dtos;

import com.org.backend.exceptions.EntityBadRequestException;

import lombok.Data;

@Data
public class TelephoneDto {
	private String telephone;
	
	public void validateSave() {
		if (telephone == null || telephone.isEmpty())
			throw new EntityBadRequestException("telephone is empty");
		if (telephone.length() > 20)
			throw new EntityBadRequestException("phone greater than 20 characters");
	}
}
