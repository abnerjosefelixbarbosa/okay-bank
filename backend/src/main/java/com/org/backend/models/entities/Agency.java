package com.org.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"accounts"})
@EqualsAndHashCode(exclude = {"accounts"})
@Entity
@Table(name = "agency")
@JsonIgnoreProperties({"accounts"})
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String agency;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@OneToMany(mappedBy = "agency")
	private List<Account> accounts;
}
