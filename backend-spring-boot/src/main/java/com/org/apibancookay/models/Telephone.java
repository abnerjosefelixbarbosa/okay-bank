package com.org.apibancookay.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"telephone", "customer"})
@Entity
@Table(name = "telephone")
public class Telephone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Column(length = 20, nullable = false, unique = true)
	private String telephone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, unique = true)
	private Customer customer;
}
