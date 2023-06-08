package com.org.backend.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class CustomerDto {
	private UUID id;
	private String name;
    private String cpf;
    private String rg;
    private String password;
    private String email;
    private String telephone;
    private LocalDate birthDate;
    private Integer addressNumber;
    private String addressZipCode;
	private String addressName;
	private String addressNeighborhood;
	private String addressCity;
	private String addressState;
}
