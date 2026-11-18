package com.okay_bank.backend.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "account_transfer_tb")
public class AccountTransferEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@ManyToOne
	@JoinColumn(name = "transfer_id", nullable = false)
    private TransferEntity transfer;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
