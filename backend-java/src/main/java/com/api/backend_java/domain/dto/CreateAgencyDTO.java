package com.api.backend_java.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAgencyDTO {
	@NotEmpty(message = "number should not be empty")
	@NotNull(message = "number should not be null")
	@Size(max = 10, message = "number should have in maximum 10 charactes")
	@Pattern(regexp = "^\\d+$", message = "number should have numeric digits")
	private String number;
}