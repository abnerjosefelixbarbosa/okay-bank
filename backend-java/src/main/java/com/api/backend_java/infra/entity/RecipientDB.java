package com.api.backend_java.infra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipient_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, length = 10)
	private String account;
	@Column(nullable = false, length = 10)
	private String agency;
	@Column(nullable = false, length = 50)
	private String bank;
	@Column(nullable = false, length = 100)
	private String name;
}
