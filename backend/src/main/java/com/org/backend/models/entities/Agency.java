package com.org.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.org.backend.models.dtos.AgencyDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"employee", "accounts"})
@Entity
@Table(name = "agency")
@JsonIgnoreProperties({"accounts"})
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@EqualsAndHashCode.Include
	private String id;
	@Column(nullable = false, unique = true, length = 10)
	private String agency;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@OneToMany(mappedBy = "agency")
	private List<Account> accounts;
	
	public Agency(AgencyDto dto) {
		this.id = dto.getId();
		this.agency = dto.getAgency();
		this.employee = new Employee(dto.getEmployee());
	}
}
