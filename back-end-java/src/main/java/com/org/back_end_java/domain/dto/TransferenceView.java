package com.org.back_end_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransferenceView {
	private String id;
	private LocalDateTime dateTime;
	private BigDecimal valueTransference;
	private CustomerView customer;
	private RecipientView recipient;
}
