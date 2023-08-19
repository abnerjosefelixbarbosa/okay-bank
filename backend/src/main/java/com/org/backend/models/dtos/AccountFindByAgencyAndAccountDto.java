package com.org.backend.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFindByAgencyAndAccountDto {
	@NotNull(message = "Agency is null")
	@NotEmpty(message = "Agency is empty")
	@Size(min = 10, max = 10, message = "Agency is different than 10 digits")
	private String agency;
	@NotNull(message = "Account is null")
	@NotEmpty(message = "Account is empty")
	@Size(min = 10, max = 10, message = "Account is different than 10 digits")
	private String account;
}
