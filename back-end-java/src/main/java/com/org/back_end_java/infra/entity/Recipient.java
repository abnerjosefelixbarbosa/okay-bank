package com.org.back_end_java.infra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_recipient")
public class Recipient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, length = 50)
	private String numberAgency;
	@Column(nullable = false, length = 50)
	private String numberAccount;
	@Column(nullable = false, length = 30)
	private String nameBank;
}
