package com.org.back_end_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.domain.entity.AccountType;
import com.org.back_end_java.infra.repository.IAccountRepository;
import com.org.back_end_java.infra.repository.IAgencyRepository;
import com.org.back_end_java.infra.repository.ICustomerRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IAgencyRepository agencyRepository;

	@BeforeEach
	public void setup() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@AfterEach
	public void tearDown() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@Test
	public void shouldRegisterAndReturnStatus201() throws Exception {
		RegisterCustomerDTO dto = new RegisterCustomerDTO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = format.parse("1990-05-02");
		
		dto.setCustomerName("name1");
		dto.setCustomerEmail("email1@gmail.com.br");
		dto.setCustomerPassword("1");
		dto.setCustomerContact("(81) 91111-1111");
		dto.setCustomerCpf("632.872.105-64");
		dto.setCustomerRg("21.500.362");
		dto.setCustomerBirthDate(birthDate);
		
		dto.setAddressPostalCode("07076-080");
		dto.setAddressNumber("350");
		dto.setAddressName("Rua Armando Luongo");
		dto.setAddressDistrict("Jardim Palmira");
		dto.setAddressCity("Guarulhos");
		dto.setAddressState("São Paulo");
		
		dto.setAccountNumber("11111-1");
		dto.setAccountType(AccountType.SAVINGS);
		dto.setAccountPassword("1");
		
		dto.setAgencyNumber("1111-1");
		
		String json = objectMapper.writeValueAsString(dto);
		
		MvcResult result = mockMvc.perform(post("/customers/register")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated())
				.andDo(print())
				.andReturn();
		
		Assertions.assertEquals("registrado com sucesso", result.getResponse().getContentAsString());
	}
}
