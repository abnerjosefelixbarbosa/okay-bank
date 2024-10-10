package com.api.backend_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.backend_java.infra.entity.Transference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDTO {
	private String id;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private BigDecimal valueTransference;
    private AccountDTO account;
    private RecipientDTO recipient;
    
    public TransferenceDTO(Transference transference) {
		this.id = transference.getId();
		this.dateTime = transference.getDateTime();
		this.valueTransference = transference.getTrasnsferenceValue();
		this.account = new AccountDTO(transference.getAccount());
		this.recipient = new RecipientDTO(transference.getRecipient());
	}
}