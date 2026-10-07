package com.okaybank.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;

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
public class EmployeeRequestDTO {
	@NotNull(message = "Matrícula não deve ser nulo.")
	@Pattern(regexp = "^[0-9]{10}", message = "Matrícula deve ter 10 caracteres numéricos.")
	private String matriculation;
	@NotNull(message = "Data de nascimento não deve ser nulo.")
	private LocalDate birthDate;
	@NotNull(message = "CPF não deve ser nulo ou vázio.")
	@Size(message = "CPF não deve ter mais de 11 caracteres", max = 11)
	@CPF(message = "CPF deve ser valido.")
	@Pattern(regexp = "^[0-9]*$", message = "CPF deve conter número.")
	private String cpf;
	@NotNull(message = "Nome não deve ser nulo ou vázio.")
	@NotEmpty(message = "Nome não deve ser nulo ou vázio.")
	@Size(message = "Nome não deve ter mais de 100 caracteres.", max = 100)
	private String name;
	@NotNull(message = "Salário não deve ser nulo.")
	private BigDecimal salary;
	@NotNull(message = "Email não deve ser nulo ou vázio.")
	@NotEmpty(message = "Email não deve ser nulo ou vázio.")
	@Size(message = "Email não deve ter mais de 30 caracteres", max = 30)
	@Email(message = "Email deve ser valido.")
	private String email;
	@NotNull(message = "Telefone não deve ser nulo ou vázio.")
	@NotEmpty(message = "Telefone não deve ser nulo ou vázio.")
	@Size(message = "Telefone não deve ter mais de 30 caracteres.", max = 30)
	@Pattern(regexp = "^[0-9]*$", message = "Telefone deve conter número.")
	private String phone;
	@NotNull(message = "Jornada não deve ser nulo.")
	private Integer journey;
	@NotNull(message = "Tipo de funcionário não deve ser nulo.")
	private EmployeeType employeeType;
	@NotNull(message = "Status de funcionário não deve ser nulo.")
	private EmployeeStatus employeeStatus;
	@NotNull(message = "Codigo postal não deve ser nulo ou vázio.")
	@NotEmpty(message = "Codigo postal não deve ser nulo ou vázio.")
	@Size(message = "Codigo postal não ter mais de 10 caracteres.", max = 10)
	@Pattern(regexp = "^[0-9]*$", message = "Codigo postal deve conter número.")
	private String postalCode;
	@NotNull(message = "Nome  do endereço não deve ser nulo ou vazio.")
	@NotEmpty(message = "Nome  do endereço não deve ser nulo ou vazio.")
	@Size(message = "Nome do endereço não deve ter mais de 30 caracteres.", max = 30)
	private String addressName;
	@NotNull(message = "Numero do endereço não deve ser nulo.")
	private Integer number;
	@NotNull(message = "Distrito não deve ser nulo ou vazio.")
	@NotEmpty(message = "Distrito não deve ser nulo ou vazio.")
	@Size(message = "Distrito não deve ter mais de 30 caracteres.", max = 30)
	private String district;
	@NotNull(message = "Cidade não deve ser nula ou vazia.")
	@NotEmpty(message = "Cidade não deve ser nula ou vazia.")
	@Size(message = "Cidade não deve ter mais de 30 caracteres", max = 30)
	private String city;
	@NotNull(message = "Estado não deve ser nulo ou vazio")
	@NotEmpty(message = "Estado não deve ser nulo ou vazio")
	@Size(message = "Estado não deve ter mais de 30 caracteres", max = 30)
	private String state;
	@NotNull(message = "Agency number não deve ser nulo ou vazio")
	@NotEmpty(message = "Agency Number não deve ser nulo ou vazio")
	@Size(message = "Agency number não deve ter mais de 5 caracteres", max = 5)
	@Pattern(regexp = "^[0-9]{5}", message = "Numero da agência deve ter 5 caracteres numéricos.")
	private String agencyNumber;
}
