package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
	private String cpf;
	private String password;
	private String token;
}