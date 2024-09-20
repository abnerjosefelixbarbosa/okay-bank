package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginCustomerDTO {
	@NotNull(message = "cpf should not be null")
	@NotEmpty(message = "cpf should not be empty")
	@CPF(message = "cpf should not be invalid")
	@Pattern(regexp = "^\\d{11}$", message = "cpf should have 11 numeric digits")
	private String cpf;
	@NotNull(message =  "password should not be null")
	@NotEmpty(message = "password should not be empty")
	@Pattern(regexp = "^\\d{8}$", message = "password should have 8 numeric digits")
	private String password;
}