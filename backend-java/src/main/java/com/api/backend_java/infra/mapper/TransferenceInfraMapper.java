package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Recipient;
import com.api.backend_java.infra.entity.Transference;

@Component
public class TransferenceInfraMapper {
	public Transference toTransference(TransferAccountDTO dto, Recipient recipient, Account account) {
		Transference transference = new Transference(dto, recipient, account);
		
		return transference;
	}
}
