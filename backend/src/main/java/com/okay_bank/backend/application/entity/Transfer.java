package com.okay_bank.backend.application.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
	private String id;
	private Payer payer;
	private Receiver receiver;
	private BigDecimal value;
	private LocalDateTime transferDateAndTime;
	private TransferType transferType;
	private List<AccountTransfer> accountTransfers;
}
