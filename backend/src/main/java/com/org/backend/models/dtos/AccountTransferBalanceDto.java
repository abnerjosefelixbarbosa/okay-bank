package com.org.backend.models.dtos;

import java.math.BigDecimal;

import com.org.backend.controllers.exceptions.EntityBadRequestException;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountTransferBalanceDto {
	@NotNull(message = "Balance is null")
	private BigDecimal balance;
	
	public void validation() {
		if (balance.doubleValue() == 0.00) {
			throw new EntityBadRequestException("Balance is 0");
		}
		if (balance.scale() != 2) {
			throw new EntityBadRequestException("Balance scale is different than 2 digits");
		}
	}
}
