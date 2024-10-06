package com.api.backend_java.domain.dto;

import com.api.backend_java.domain.entity.AccountType;

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
public class CreateAccountDTO {
	@NotNull(message = "number should not be null")
	@NotEmpty(message = "number should not be empty")
	@Size(max = 10, message = "number should have in maximum 10 character")
	@Pattern(regexp = "^\\d+$", message = "number should have numeric digits")
	private String number;
	@NotNull(message = "account should not be null")
	private AccountType accountType;
	@NotNull(message = "password should not be null")
	@NotEmpty(message = "password should not be empty")
	@Pattern(regexp = "^\\d{6}$", message = "password should have 6 numeric digits")
 	private String password;
	@NotNull(message = "customer id should not be null")
	@NotEmpty(message = "customer id should not be empty")
	private String customerId;
	@NotNull(message = "agency id should not be null")
	@NotEmpty(message = "agency id should not be empty")
	private String agencyId;
}