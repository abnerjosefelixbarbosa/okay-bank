package com.okaybank.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgencyRequestDTO {
	@NotNull(message = "Número não deve ser nulo ou vazio.")
	@NotEmpty(message = "Número não deve ser nulo ou vazio.")
	@Pattern(message = "Número deve ter 5 caracteres numéricos.", regexp = "^[0-9]{5}")
	private String number;
}
