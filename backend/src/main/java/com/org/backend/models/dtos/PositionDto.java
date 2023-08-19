package com.org.backend.models.dtos;

import com.org.backend.models.entities.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
	private String id;
	private String position;
	private Double bonus;
	
	public PositionDto(Position position) {
		this.id = position.getId();
		this.position = position.getPosition();
		this.bonus = position.getBonus();
	}
}
