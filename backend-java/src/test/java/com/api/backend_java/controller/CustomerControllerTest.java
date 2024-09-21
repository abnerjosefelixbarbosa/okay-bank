package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import com.api.backend_java.domain.dto.CreateCustomerDTO;
import com.github.f4b6a3.ulid.UlidCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginCustomerDTO;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private ICustomerRepository customerRepository;

	@BeforeEach
	void setUp() {
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		customerRepository.deleteAll();
	}

	@Test
	@DisplayName("should return status 201 and return customer")
	void createCase1() throws Exception {
		CreateCustomerDTO dto = new CreateCustomerDTO();
		dto.setName("name1");
		dto.setEmail("email1@gmail.com");
		dto.setPassword("11111111");
		dto.setContact("81911111111");
		dto.setCpf("36896983086");
		dto.setRg("11111");
		dto.setBirthDate(LocalDate.of(1990, 11, 11));
		dto.setAddressPostalCode("11111");
		dto.setAddressNumber("1");
		dto.setAddressName("name1");
		dto.setAddressDistrict("district1");
		dto.setAddressCity("city1");
		dto.setAddressState("state1");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isCreated())
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return status 400 and customer exists message")
	void createCase2() throws Exception {
		loadCustomer();

		CreateCustomerDTO dto = new CreateCustomerDTO();
		dto.setName("name1");
		dto.setEmail("email1@gmail.com");
		dto.setPassword("11111111");
		dto.setContact("81911111111");
		dto.setCpf("36896983086");
		dto.setRg("11111");
		dto.setBirthDate(LocalDate.of(1990, 11, 11));
		dto.setAddressPostalCode("11111");
		dto.setAddressNumber("1");
		dto.setAddressName("name1");
		dto.setAddressDistrict("district1");
		dto.setAddressCity("city1");
		dto.setAddressState("state1");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message").value("cpf, rg, email, contact or password exists"))
		.andDo(print())
		.andReturn();
	}

	@Test
	@DisplayName("should return status 400 and data invalid message")
	void createCase3() throws Exception {
		CreateCustomerDTO dto = new CreateCustomerDTO();
		dto.setName(null);
		dto.setEmail(null);
		dto.setPassword(null);
		dto.setContact(null);
		dto.setCpf(null);
		dto.setRg(null);
		dto.setBirthDate(null);
		dto.setAddressPostalCode(null);
		dto.setAddressNumber(null);
		dto.setAddressName(null);
		dto.setAddressDistrict(null);
		dto.setAddressCity(null);
		dto.setAddressState(null);
		String json = objectMappe.writeValueAsString(dto);

		mockMvc.perform(
						post("/customers/create")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
								.content(json)
				)
				.andExpect(status().isBadRequest())
				.andDo(print())
				.andReturn();
	}
	
	@Test
	@DisplayName("should return status 200 and return customer")
	void loginCase1() throws Exception {
		loadCustomer();

		LoginCustomerDTO dto = new LoginCustomerDTO();
		dto.setCpf("36896983086");
		dto.setPassword("11111111");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isOk())
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return status 404 and return customer not found message")
	void loginCase2() throws Exception {
		loadCustomer();

		LoginCustomerDTO dto = new LoginCustomerDTO();
		dto.setCpf("36896983086");
		dto.setPassword("11111112");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isNotFound())
		.andExpect(jsonPath("$.message").value("customer not found"))
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return status 400 and return data invalid message")
	void loginCase3() throws Exception {
		LoginCustomerDTO dto = new LoginCustomerDTO();
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andReturn();
	}

	void loadCustomer() {
		Customer customer = new Customer();
		customer.setId(UlidCreator.getUlid().toString());
		customer.setName("name1");
		customer.setEmail("email1@gmail.com");
		customer.setPassword("11111111");
		customer.setContact("81911111111");
		customer.setCpf("36896983086");
		customer.setRg("11111");
		customer.setBirthDate(LocalDate.of(1990, 11, 11));
		customer.setAddressPostalCode("11111");
		customer.setAddressNumber("1");
		customer.setAddressName("name1");
		customer.setAddressDistrict("district1");
		customer.setAddressCity("city1");
		customer.setAddressState("state1");
		
		customerRepository.save(customer);
	}
}
