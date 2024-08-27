package com.api.backend_java.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transference {
	private String id;
	private BigDecimal value;
	private LocalDateTime dateTime;
	private Customer customer;
	private Recipient recipient;
}
