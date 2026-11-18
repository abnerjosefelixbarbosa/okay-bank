package com.okay_bank.backend.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transfer_tb")
public class TransferEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Embedded
	private PayerEntity payer;
	@Embedded
	private ReceiverEntity receiver;
	@Column(name = "transfer_value", scale = 2, nullable = false)
	private BigDecimal value;
	@Column(name = "transfer_date_and_time", nullable = false)
	private LocalDateTime transferDateAndTime;
	@Column(name = "transfer_type", nullable = false)
	private TransferTypeEntity transferType;
	@OneToMany(mappedBy = "transfer", fetch = FetchType.LAZY)
	private List<AccountTransferEntity> accountTransfers;
}
