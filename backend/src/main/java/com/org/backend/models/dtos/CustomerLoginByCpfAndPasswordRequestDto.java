package com.org.backend.models.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerLoginByCpfAndPasswordRequestDto {
	@CPF(message = "CPF invalid")
    private String cpf;
	@NotNull(message = "Password is null")
	@NotEmpty(message = "Password is empty")
	@Size(min = 6, max = 6, message = "Password is different than 6 digits")
	private String password;
}
