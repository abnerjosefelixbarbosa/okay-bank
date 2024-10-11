package com.api.backend_java.domain.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.domain.entity.Account;
import com.api.backend_java.domain.entity.Recipient;
import com.api.backend_java.domain.entity.Transference;

@Component
public class TransferenceDomainMapper {
	public Transference toTransference(TransferAccountDTO dto) {
        Recipient recipient = new Recipient(dto);
		
		Account account = new Account(dto);
		
		Transference transference = new Transference(dto);
		transference.setRecipient(recipient);
		transference.setAccount(account);
		
		return transference;
	}
}