package com.org.back_end_java.infra.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false)
	private Date dateExpiration;
	@Column(nullable = false, unique = true)
	private String cvv;
	@OneToOne
	@JoinColumn(name = "id_account", nullable = false)
	private Account account;
}
