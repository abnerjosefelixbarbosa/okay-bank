package com.api.backend_java.domain.dto;

import com.api.backend_java.infra.entity.Recipient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDTO {
	private String id;
    private String name;
    private String account;
    private String agency;
    private String bank;
    
    public RecipientDTO(Recipient recipient) {
		this.id = recipient.getId();
		this.name = recipient.getName();
		this.account = recipient.getAccount();
		this.agency = recipient.getAgency();
		this.bank = recipient.getBank();
	}
}
