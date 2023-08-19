package com.org.backend.models.dtos;

import com.org.backend.models.entities.Position;

import lombok.Data;

@Data
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
