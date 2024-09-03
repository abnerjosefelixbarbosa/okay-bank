package com.api.backend_java.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transference {
	private String id;
	private LocalDateTime dateTime;
	private BigDecimal valueTransference;
	private Customer customer;
	private Recipient recipient;
}
