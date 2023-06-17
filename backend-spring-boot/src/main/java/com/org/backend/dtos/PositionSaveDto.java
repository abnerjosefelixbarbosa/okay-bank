package com.org.backend.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PositionSaveDto {
	@NotNull(message = "Position is null")
	@NotEmpty(message = "Position is empty")
	@Length(max = 30, message = "Position is greater than 30 characters")
	private String position;
	@NotNull(message = "Bonus is null")
	private Double bonus;
}
