package com.api.backend_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;

@RequestMapping(value = "/agencies")
@RestController
public class AgencyController {

	@PostMapping(value = "/create")
	public ResponseEntity<AgencyView> create(AgencyDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
