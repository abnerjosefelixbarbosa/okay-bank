package com.api.backend_java.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class AccountControllerTest {
	/*
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private IAgencyRepository agencyRepository;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountRepository accountRepository;

	@BeforeEach
	void setup() {
		accountRepository.deleteAll();
		agencyRepository.deleteAll();
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		accountRepository.deleteAll();
		agencyRepository.deleteAll();
		customerRepository.deleteAll();
	}

	@Test
	@DisplayName("should return status 201")
	void create() throws Exception {
		AgencyDTO agencyDTO = createAgency(
				UUID.randomUUID().toString(),
				"1111"
		);
		
		CustomerDTO customerDTO;
		
		AccountDTO dto = new AccountDTO(
				null,
				"11111",
				BigDecimal.ZERO,
				AccountType.SAVINGS,
				"111111"
		);
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/accounts/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)
		)
		.andExpect(status().isCreated())
		.andDo(print())
		.andReturn();
	}
	
	AgencyDTO createAgency(String id, String number) {
		Agency agency = new Agency(
			id,
			number
		);
		
		agencyRepository.save(agency);
		
		return new AgencyDTO(
				agency.getId(),
				agency.getNumber()
		);
	}
	
	CustomerDTO createCustomer(String id, String name, String email, String password, String contact, String cpf,
			String rg, LocalDate birthDate, String addressPostalCode, String addressNumber, String addressName,
			String addressDistrict, String addressCity, String addressState) {
		
		Customer customer = new C
	}
	
	void loadAccount() {
	}
	*/
}