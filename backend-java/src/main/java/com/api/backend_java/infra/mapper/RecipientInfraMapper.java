package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.infra.entity.Recipient;

@Component
public class RecipientInfraMapper {
	public Recipient toRecipient(TransferAccountDTO dto) {
		Recipient recipient = new Recipient(dto);
		
		return recipient;
	}
}