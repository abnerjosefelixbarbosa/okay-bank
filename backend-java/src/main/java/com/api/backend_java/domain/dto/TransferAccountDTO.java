package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferAccountDTO {
	@NotNull(message = "agency should not be null")
	@NotEmpty(message = "agency should not be empty")
	private String agency;
	@NotNull(message = "account should not be null")
	@NotEmpty(message = "account should not be empty")
	private String account;
	@NotNull(message = "bank should not be null")
	@NotEmpty(message = "bank should not be empty")
	private String bank;
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	private String name;
	@NotNull(message = "balance should not be null")
	private BigDecimal balance;
}
