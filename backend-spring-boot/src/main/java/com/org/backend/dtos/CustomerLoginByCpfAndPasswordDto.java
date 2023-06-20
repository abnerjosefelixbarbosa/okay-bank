package com.org.backend.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerLoginByCpfAndPasswordDto {
	@CPF(message = "CPF invalid")
	private String cpf;
	@Size(min = 6, max = 6, message = "Password is diferent of 6 characteres")
	private String password;
}
