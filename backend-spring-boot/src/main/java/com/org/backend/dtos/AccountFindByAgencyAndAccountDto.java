package com.org.backend.dtos;

import com.org.backend.models.Agency;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountFindByAgencyAndAccountDto {
	@NotNull
	private String account;
	private Agency agency;
}
