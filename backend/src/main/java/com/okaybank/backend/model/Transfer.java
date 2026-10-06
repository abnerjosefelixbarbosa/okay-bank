package com.okaybank.backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transfer_tb")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id ;
	@Embedded
	private Payer payer;
	@Embedded
	private Receiver receiver;
	@Column(precision = 30, scale = 2, nullable = false)
	private BigDecimal value;
	@Column(nullable = false)
	private LocalDateTime transferDateAndTime;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransferType transferType;
	@OneToMany(mappedBy = "transfer", fetch = FetchType.LAZY)
	private List<AccountTransfer> accountTransfers;
}
