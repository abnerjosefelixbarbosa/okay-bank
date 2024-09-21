package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.entity.AccountType;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.IAccountRepository;
import com.api.backend_java.infra.repository.IAgencyRepository;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.ulid.UlidCreator;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMappe;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IAgencyRepository agencyRepository;
    @Autowired
    private IAccountRepository accountRepository;
    private Customer customer = new Customer();
    private Agency agency = new Agency();

    @BeforeEach
    void setUp() {
    	accountRepository.deleteAll();
        customerRepository.deleteAll();
        agencyRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
    	accountRepository.deleteAll();
        customerRepository.deleteAll();
        agencyRepository.deleteAll();
    }

    @Test
    @DisplayName("should return 201 and return account")
    void createCase1() throws Exception {
    	loadAgency();
    	loadCustomer();
    	
        CreateAccountDTO dto = new CreateAccountDTO();
        dto.setNumber("111111");
        dto.setAccountType(AccountType.CURRENT);
        dto.setPassword("111111");
        dto.setAgencyId(agency.getId());
        dto.setCustomerId(customer.getId());
        String json = objectMappe.writeValueAsString(dto);
        
        mockMvc.perform(post("/accounts/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print())
				.andReturn();
    }
    
    @Test
    @DisplayName("should return 400 and return data invalid mesager")
    void createCase2() throws Exception {
        CreateAccountDTO dto = new CreateAccountDTO();
        String json = objectMappe.writeValueAsString(dto);
        
        mockMvc.perform(post("/accounts/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest()).andDo(print())
				.andReturn();
    }
    
    @Test
    @DisplayName("should return 404 and return not found mesager")
    void createCase3() throws Exception {
    	loadAgency();
    	loadCustomer();
    	
        CreateAccountDTO dto = new CreateAccountDTO();
        dto.setNumber("111111");
        dto.setAccountType(AccountType.CURRENT);
        dto.setPassword("111111");
        dto.setAgencyId(agency.getId() + "2");
        dto.setCustomerId(customer.getId() + "2");
        String json = objectMappe.writeValueAsString(dto);
        
        mockMvc.perform(post("/accounts/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isNotFound()).andDo(print())
				.andReturn();
    }
    
    void loadAgency() {
		Agency agency = new Agency();
		agency.setId(UlidCreator.getUlid().toString());
		agency.setNumber("11111");

		this.agency = agencyRepository.save(agency);
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

		this.customer = customerRepository.save(customer);
	}
}