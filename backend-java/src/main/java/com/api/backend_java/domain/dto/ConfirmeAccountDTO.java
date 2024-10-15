package com.api.backend_java.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmeAccountDTO {
	@NotNull(message = "password should not be null")
	@NotEmpty(message = "password should not be empty")
	@Pattern(regexp = "^\\d{6}$", message = "password should have 6 numeric digits")
	private String password;
}