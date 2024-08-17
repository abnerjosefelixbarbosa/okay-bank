package com.org.back_end_java.infra.entity;

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
import lombok.Data;

@Data
@Entity
@Table(name = "tb_transference")
public class Transference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false)
	private LocalDateTime dateTime;
	@Column(nullable = false)
	private BigDecimal valueTransference;
	@ManyToOne
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "id_recipient", nullable = false)
	private Recipient recipient;
}
