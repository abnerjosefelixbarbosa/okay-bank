package com.org.backend.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PositionSaveDto {
	@NotNull(message = "Position is null")
	@NotEmpty(message = "Position is empty")
	@Size(max = 30, message = "Position is greater than 30 characters")
	private String position;
	private Double bonus;
}
