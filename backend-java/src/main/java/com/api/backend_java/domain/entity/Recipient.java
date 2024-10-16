package com.api.backend_java.domain.entity;

import com.api.backend_java.domain.dto.TransferAccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {
	private String id;
	private String name;
	private String account;
	private String agency;
	private String bank;
	
	public Recipient(TransferAccountDTO dto) {
		this.account = dto.getAccount();
		this.agency = dto.getAgency();
		this.bank = dto.getBank();
		this.name = dto.getName();
	}
}