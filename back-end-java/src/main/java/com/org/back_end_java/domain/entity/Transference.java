package com.org.back_end_java.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transference {
	private String id;
	private LocalDateTime transferenceDateTime;
	private BigDecimal transferenceValue;
	private Customer customer;
	private Recipient recipient;
}
