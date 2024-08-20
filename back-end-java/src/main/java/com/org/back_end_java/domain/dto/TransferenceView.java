package com.org.back_end_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class TransferenceView {
	private String id;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime transferenceDateTime;
	private BigDecimal transferenceValue;
	private CustomerView customer;
	private RecipientView recipient;
}
