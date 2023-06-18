package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.interfaces.PositionMethods;
import com.org.backend.models.Position;
import com.org.backend.repositories.PositionRepository;

@Service
public class PositionService implements PositionMethods {
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private PositionValidation positionValidation;

	public String save(Position position) {
		positionValidation.validateSave(position);
		positionRepository.save(position);
		return "Position was saved with success";
	}
}
