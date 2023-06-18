package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityBadRequestException;
import com.org.backend.models.Position;
import com.org.backend.repositories.PositionRepository;

@Service
public class PositionValidation {
	@Autowired
	private PositionRepository positionRepository;
	
    public void validateSave(Position position) {
		if (positionRepository.existsByPosition(position.getPosition())) {
			throw new EntityBadRequestException("Position exist");
		}
	}
}
