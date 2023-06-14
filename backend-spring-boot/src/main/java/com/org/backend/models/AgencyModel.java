package com.org.backend.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"accountModels"})
@EqualsAndHashCode(exclude = {"accountModels"})
@Entity
@Table(name = "agency")
@JsonIgnoreProperties({"accountModels"})
public class AgencyModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 20, nullable = false, unique = true)
	private String agency;
	@OneToMany(mappedBy = "agencyModel")
	List<AccountModel> accountModels;
}
