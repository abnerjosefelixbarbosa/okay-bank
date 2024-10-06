package com.api.backend_java.infra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Recipient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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
