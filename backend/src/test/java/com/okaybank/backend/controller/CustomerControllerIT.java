package com.okaybank.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.okaybank.backend.dto.CustomerRequestDTO;
import com.okaybank.backend.model.Address;
import com.okaybank.backend.model.Customer;
import com.okaybank.backend.model.CustomerType;
import com.okaybank.backend.repository.CustomerRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class CustomerControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	void setUp() throws Exception {
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		customerRepository.deleteAll();
	}

	@Test
	@DisplayName("Should register customer and return 201 status.")
	void registerCustomerTest1() throws Exception {
		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	@DisplayName("Should not register customer when address number is 0 and return 400 status.")
	void registerCustomerTest2() throws Exception {
		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 0, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Numero do endereço não deve ser 0.")).andDo(print());
	}

	@Test
	@DisplayName("Should not register customer when document is repeated and return 400 status.")
	void registerCustomerTest3() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "62539852483", LocalDate.now().withYear(1995), "Nome2",
				"email2@gmail.com", address, "81922222222", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento, nome, email ou telefone não devem ser repetidos."))
				.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register customer when name is repeated and return 400 status.")
	void registerCustomerTest4() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "32085527426", LocalDate.now().withYear(1995), "Nome1",
				"email2@gmail.com", address, "81922222222", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento, nome, email ou telefone não devem ser repetidos."))
				.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register customer when email is repeated and return 400 status.")
	void registerCustomerTest5() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "32085527426", LocalDate.now().withYear(1995), "Nome2",
				"email1@gmail.com", address, "81922222222", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento, nome, email ou telefone não devem ser repetidos."))
				.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register customer when name is repeated and return 400 status.")
	void registerCustomerTest6() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "32085527426", LocalDate.now().withYear(1995), "Nome1",
				"email2@gmail.com", address, "81911111111", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("62539852483", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento, nome, email ou telefone não devem ser repetidos."))
				.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register customer when CPF is invalid and return 400 status.")
	void registerCustomerTest7() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "32085527426", LocalDate.now().withYear(1995), "Nome1",
				"email2@gmail.com", address, "81911111111", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("62539852481", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PF, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento CPF deve ser valido."))
				.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register customer when CNPJ is invalid and return 400 status.")
	void registerCustomerTest8() throws Exception {
		Address address = new Address("11111", "Nome1", 40, "Distrito1", "Cidade1", "Estado1");

		Customer customer = new Customer(null, "32085527426", LocalDate.now().withYear(1995), "Nome1",
				"email2@gmail.com", address, "81911111111", CustomerType.PF, null, null);

		customerRepository.save(customer);

		CustomerRequestDTO request = new CustomerRequestDTO("05803248000101", LocalDate.now().withYear(1995), "Nome1",
				"email1@gmail.com", "81911111111", CustomerType.PJ, "111111", "Nome1", 40, "Distrito1", "Cidade1",
				"Estado1");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Documento CNPJ deve ser valido."))
				.andDo(print());
	}
}
