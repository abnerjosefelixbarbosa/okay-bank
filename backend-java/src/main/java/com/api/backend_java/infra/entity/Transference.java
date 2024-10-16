package com.api.backend_java.infra.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transference_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transference implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column(nullable = false)
	private LocalDateTime dateTime;
	@Column(nullable = false)
	private BigDecimal trasnsferenceValue;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	@ManyToOne
	@JoinColumn(name = "recipient_id", nullable = false)
	private Recipient recipient;
	
	public Transference(TransferAccountDTO dto, Recipient recipient, Account account) {
		this.id = UlidCreator.getUlid().toString();
		this.dateTime = LocalDateTime.now();
		this.trasnsferenceValue = dto.getBalance();
		this.account = account;
		this.recipient = recipient;
	}
}
