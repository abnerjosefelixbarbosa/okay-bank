package com.okaybank.backend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgencyResponseDTO {
	private String id;
	private String number;
	private LocalDate creationDate;
}
