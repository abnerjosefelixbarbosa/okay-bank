package com.org.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.org.backend.models.dtos.PositionDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString(exclude = {"position", "employees"})
@Entity
@Table(name = "position")
@JsonIgnoreProperties({ "employees" })
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@EqualsAndHashCode.Include
	private String id;
	@Column(nullable = false, unique = true, length = 30)
	@EqualsAndHashCode.Include
	private String position;
	@Column(nullable = true)
	private Double bonus;
	@OneToMany(mappedBy = "position")
	private List<Employee> employees;
	
	public Position(PositionDto dto) {
		this.id = dto.getId();
		this.position = dto.getPosition();
		this.bonus = dto.getBonus();
	}
}
