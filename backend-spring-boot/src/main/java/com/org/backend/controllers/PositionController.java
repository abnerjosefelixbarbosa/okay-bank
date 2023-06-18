package com.org.backend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.PositionSaveDto;
import com.org.backend.interfaces.PositionMethods;
import com.org.backend.models.Position;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/positions")
public class PositionController {
	@Autowired
	private PositionMethods positionMethods;

	@Operation(description = "Save position")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request") })
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> save(@Valid @RequestBody PositionSaveDto dto) {
		var position = new Position();
		BeanUtils.copyProperties(dto, position);
		var message = positionMethods.save(position);
		return ResponseEntity.status(201).body(message);
	}
}
