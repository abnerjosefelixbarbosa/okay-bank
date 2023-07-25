package com.org.backend.models.dtos;

import lombok.Data;

@Data
public class AccountGetAllByCustomerIdResponseDto {
	private String id;
	private String agency;
	private String account;	
}
