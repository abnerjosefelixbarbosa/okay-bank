package com.org.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.backend.dtos.PositionSaveDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/positions")
public class PositionController {
	
	@Operation(description = "save position")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Ok"),
		@ApiResponse(responseCode = "400", description = "Bad request")
	})
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody PositionSaveDto dto) {
		String message = "Position was saved with success";
		return ResponseEntity.status(201).body(message);
	}
}
