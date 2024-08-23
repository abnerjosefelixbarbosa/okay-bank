package com.org.back_end_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

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
import com.org.back_end_java.infra.entity.Account;
import com.org.back_end_java.infra.entity.Address;
import com.org.back_end_java.infra.entity.Agency;
import com.org.back_end_java.infra.entity.Customer;
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
		
		//loadDate();
		
		dto.setCustomerName("name1");
		dto.setCustomerEmail("email1@gmail.com.br");
		dto.setCustomerPassword("11111111");
		dto.setCustomerContact("(81) 91111-1111");
		dto.setCustomerCpf("63287210564");
		dto.setCustomerRg("21500362");
		dto.setCustomerBirthDate(LocalDate.of(1990, 11, 20));
		
		dto.setAddressPostalCode("07076-080");
		dto.setAddressNumber("350");
		dto.setAddressName("Rua Armando Luongo");
		dto.setAddressDistrict("Jardim Palmira");
		dto.setAddressCity("Guarulhos");
		dto.setAddressState("São Paulo");
		
		dto.setAccountNumber("11111-1");
		dto.setAccountType(AccountType.SAVINGS);
		dto.setAccountPassword("111111");
		
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
	
	private void loadDate() {
		Address address = new Address();
		address.setName("Rua Armando Luongo");
		address.setCity("Guarulhos");
		address.setDistrict("Jardim Palmira");
		address.setNumber("350");
		address.setPostalCode("07076-080");
		address.setState("São Paulo");
		
		Customer customer = new Customer();
		customer.setId(UUID.randomUUID().toString());
		customer.setAddress(address);
		customer.setBirthDate(LocalDate.of(1990, 11, 20));
		customer.setContact("(81) 91111-1111");
		customer.setCpf("63287210564");
		customer.setEmail("email1@gmail.com.br");
		customer.setName("name1");
		customer.setPassword("1");
		customer.setRg("21500362");
		
		Agency agency = new Agency();
		agency.setId(UUID.randomUUID().toString());
		agency.setNumber("1111-1");
		
		Account account = new Account();
		account.setId(UUID.randomUUID().toString());
		account.setAccountType(com.org.back_end_java.infra.entity.AccountType.SAVINGS);
		account.setBalance(BigDecimal.valueOf(0));
		account.setNumber("11111-1");
		account.setPassword("1");
		
		customer = customerRepository.save(customer);
		agency = agencyRepository.save(agency);
		account.setAgency(agency);
		account.setCustomer(customer);
		accountRepository.save(account);		
	}
}
