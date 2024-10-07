package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferAccountDTO {
	@NotNull(message = "balance should not be null")
	private BigDecimal balance;
}
