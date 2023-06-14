package com.org.backend.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"customerModel"})
@EqualsAndHashCode(exclude = {"customerModel"})
@Entity
@Table(name = "telephone")
@JsonIgnoreProperties({"customerModel"})
public class TelephoneModel implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 20)
	private String telephone;
	@OneToOne(mappedBy = "telephoneModel")
	private CustomerModel customerModel;
}
