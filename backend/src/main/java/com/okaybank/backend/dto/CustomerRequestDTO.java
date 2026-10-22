package com.okaybank.backend.dto;

import java.time.LocalDate;

import com.okaybank.backend.model.CustomerType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequestDTO {
	@NotNull(message = "Documento não deve ser nulo ou vázio.")
	@NotEmpty(message = "Documento não deve ser nulo ou vázio.")
	@Size(max = 14, message = "Documento deve ter até 14 caracteres.")
	@Pattern(message = "Documento deve ter caracteres numéricos.", regexp = "^\\d*$")
	private String document;
	@NotNull(message = "Data de nascimento não deve ser nulo.")
	private LocalDate birthDate;
	@NotNull(message = "Nome não deve ser nulo ou vázio.")
	@NotEmpty(message = "Nome não deve ser nulo ou vázio.")
	@Size(message = "Nome deve ter até 100 caracteres.", max = 100)
	private String name;
	@NotNull(message = "Email não deve ser nulo ou vázio.")
	@NotEmpty(message = "Email não deve ser nulo ou vázio.")
	@Size(message = "Email deve ter até 30 caracteres.", max = 30)
	@Email(message = "Email deve ser valido.")
	private String email;
	@NotEmpty(message = "Telefone não deve ser nulo ou vázio.")
	@NotNull(message = "Telefone não deve ser nulo ou vázio.")
	@Size(message = "Telefone deve ter até 30 caracteres numéricos.", max = 30)
	@Pattern(message = "Telefone deve ter caracteres numéricos.", regexp = "^\\d*$")
	private String phone;
	@NotNull(message = "Tipo de cliente não deve ser nulo.")
	private CustomerType customerType;
	@NotEmpty(message = "Código postal do endereço não deve ser nulo ou vázio.")
	@NotNull(message = "Código postal do endereço não deve ser nulo ou vázio.")
	@Size(max = 10, message = "Código postal do endereço deve ter até 10 caracteres.")
	@Pattern(message = "Código postal do endereço deve ter caracteres numéricos.", regexp = "^\\d*$")
	private String addressPostalCode;
	@NotEmpty(message = "Nome do endereço não deve ser nulo ou vázio.")
	@NotNull(message = "Nome do endereço não deve ser nulo ou vázio.")
	@Size(message = "Nome do endereço deve ter até 30 caracteres.", max = 30)
	private String addressName;
	@NotNull(message = "Número do endereço não deve ser nulo.")
	private Integer addressNumber;
	@NotEmpty(message = "Distrito do endereço não deve ser nulo ou vázio.")
	@NotNull(message = "Distrito do endereço não deve ser nulo ou vázio.")
	@Size(message = "Distrito do endereço deve ter até 30 caracteres.", max = 30)
	private String addressDistrict;
	@NotEmpty(message = "Cidade do endereço não deve ser nula ou vázia.")
	@NotNull(message = "Cidade do endereço não deve ser nula ou vázia.")
	@Size(message = "Cidade do endereço deve ter até 30 caracteres.", max = 30)
	private String addressCity;
	@NotEmpty(message = "Estado do endereço não deve ser nulo ou vázio.")
	@NotNull(message = "Estado do endereço não deve ser nulo ou vázio.")
	@Size(message = "Estado do endereço deve ter até 30 caracteres.", max = 30)
	private String addressState;
}
