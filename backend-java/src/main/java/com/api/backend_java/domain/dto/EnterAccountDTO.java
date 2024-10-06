package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterAccountDTO {
	private String account;
	private String agency;
	private String password;
}