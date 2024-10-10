package com.api.backend_java.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferAccountDTO {
	private String agency;
	private String account;
	private String bank;
	private String name;
	//@NotNull(message = "balance should not be null")
	private BigDecimal balance;
}
