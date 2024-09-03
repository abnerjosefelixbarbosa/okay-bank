package com.api.backend_java.infra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipient_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false)
	private String account;
	@Column(nullable = false)
	private String agency;
	@Column(nullable = false)
	private String bank;
	@Column(nullable = false)
	private String name;
}
