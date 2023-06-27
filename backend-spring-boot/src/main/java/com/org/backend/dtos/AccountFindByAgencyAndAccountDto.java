package com.org.backend.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountFindByAgencyAndAccountDto {
	@NotNull(message = "Account is null")
	@NotEmpty(message = "Account is empty")
	@Size(min = 10, max = 10, message = "Account is different than 10 characters")
	private String account;
	@NotNull(message = "Agency is null")
	@NotEmpty(message = "Agency is empty")
	@Size(min = 10, max = 10, message = "Agency is different than 10 characters")
	private String agency;
}
