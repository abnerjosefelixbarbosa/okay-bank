package com.org.back_end_java.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transference {
	private String id;
	private LocalDateTime dateTime;
	private BigDecimal valueTransference;
	private Customer customer;
	private Recipient recipient;
}
