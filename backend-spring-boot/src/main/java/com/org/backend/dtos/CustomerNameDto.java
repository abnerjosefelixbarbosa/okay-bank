package com.org.backend.dtos;

import com.org.backend.exceptions.EntityBadRequestException;

import lombok.Data;

@Data
public class CustomerNameDto {
	private String name;
	
	public void validation() {
		if (name == null || name.isEmpty())
			throw new EntityBadRequestException("name is empty");
		if (name.length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");
	}
}
