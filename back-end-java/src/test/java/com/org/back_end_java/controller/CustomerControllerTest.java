package com.org.back_end_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
		List<RegisterCustomerDTO> dtos = loadRegisterCustomerDTODate();
		saveAgency();
		loadDate();

		String json = objectMapper.writeValueAsString(dtos.get(0));

		MvcResult result = mockMvc
				.perform(post("/customers/register").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated()).andDo(print()).andReturn();

		Assertions.assertEquals("registered successfully", result.getResponse().getContentAsString());
	}

	private List<RegisterCustomerDTO> loadRegisterCustomerDTODate() {
		List<RegisterCustomerDTO> registerCustomerDTOs = new ArrayList();

		RegisterCustomerDTO dto1 = new RegisterCustomerDTO();
		dto1.setCustomerName("Thiago Arthur Gonçalves");
		dto1.setCustomerEmail("thiagoarthurgoncalves@gmail.com");
		dto1.setCustomerPassword("28709525");
		dto1.setCustomerContact("81987983268");
		dto1.setCustomerCpf("70959275452");
		dto1.setCustomerRg("104956616");
		dto1.setCustomerBirthDate(LocalDate.of(1977, 04, 15));
		dto1.setAddressPostalCode("55604272");
		dto1.setAddressNumber("727");
		dto1.setAddressName("9ª Travessa Doutor Ivo Queiroz");
		dto1.setAddressDistrict("São Vicente de Paulo");
		dto1.setAddressCity("Vitória de Santo Antão");
		dto1.setAddressState("Pernambuco");
		dto1.setAccountNumber("182901");
		dto1.setAccountType(AccountType.SAVINGS);
		dto1.setAccountPassword("429164");
		dto1.setAgencyNumber("42901");
		
		
		RegisterCustomerDTO dto2 = new RegisterCustomerDTO();
		dto2.setCustomerName("Sebastião Gustavo Gomes");
		dto2.setCustomerEmail("sebastiao_gomes@gamil.com");
		dto2.setCustomerPassword("14709525");
		dto2.setCustomerContact("81992536230");
		dto2.setCustomerCpf("37916976412");
		dto2.setCustomerRg("143169646");
		dto2.setCustomerBirthDate(LocalDate.of(2005, 01, 04));
		dto2.setAddressPostalCode("55604570");
		dto2.setAddressNumber("195");
		dto2.setAddressName("Rua Genário Trajano");
		dto2.setAddressDistrict("São Vicente de Paulo");
		dto2.setAddressCity("Vitória de Santo Antão");
		dto2.setAddressState("Pernambuco");
		dto2.setAccountNumber("202901");
		dto2.setAccountType(AccountType.CURRENT);
		dto2.setAccountPassword("899062");
		dto2.setAgencyNumber("42901");

		registerCustomerDTOs.add(dto1);
		registerCustomerDTOs.add(dto2);

		return registerCustomerDTOs;
	}

	private void loadDate() {
		Address address = new Address();
		address.setName("9ª Travessa Doutor Ivo Queiroz");
		address.setCity("Vitória de Santo Antão");
		address.setDistrict("São Vicente de Paulo");
		address.setNumber("727");
		address.setPostalCode("55604272");
		address.setState("Pernambuco");

		Customer customer = new Customer();
		customer.setId(UUID.randomUUID().toString());
		customer.setAddress(address);
		customer.setBirthDate(LocalDate.of(1977, 04, 15));
		customer.setContact("81987983268");
		customer.setCpf("70959275452");
		customer.setEmail("thiagoarthurgoncalves@gmail.com");
		customer.setName("Thiago Arthur Gonçalves");
		customer.setPassword("28709525");
		customer.setRg("104956616");

		Agency agency = agencyRepository.findByNumber("42901").get();

		Account account = new Account();
		account.setId(UUID.randomUUID().toString());
		account.setAccountType(com.org.back_end_java.infra.entity.AccountType.SAVINGS);
		account.setBalance(BigDecimal.valueOf(0));
		account.setNumber("182901");
		account.setPassword("429164");

		customer = customerRepository.save(customer);
		agency = agencyRepository.save(agency);
		account.setAgency(agency);
		account.setCustomer(customer);
		accountRepository.save(account);
	}
	
	private void saveAgency() {
		Agency agency = new Agency();
		agency.setId(UUID.randomUUID().toString());
		agency.setNumber("42901");
		
		agencyRepository.save(agency);
	}
}
