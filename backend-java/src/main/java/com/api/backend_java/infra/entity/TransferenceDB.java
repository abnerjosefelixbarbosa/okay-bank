package com.api.backend_java.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class TransferenceDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, length = 10, name = "transference_value")
	private BigDecimal value;
	@Column(nullable = false, length = 10)
	private LocalDateTime dateTime;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerDB customer;
	@ManyToOne
	@JoinColumn(name = "recipient_id", nullable = false)
	private RecipientDB recipient;
}
