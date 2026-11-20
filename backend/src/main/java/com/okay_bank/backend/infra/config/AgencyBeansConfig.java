package com.okay_bank.backend.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.okay_bank.backend.application.gateway.AgencyGateway;
import com.okay_bank.backend.application.usercase.AgencyUserCase;
import com.okay_bank.backend.application.usercase.imp.AgencyUserCaseImp;

@Configuration
public class AgencyBeansConfig {
	@Bean
    public AgencyUserCase agencyUserCase(AgencyGateway agencyGateway) {
        return new AgencyUserCaseImp(agencyGateway);
    }
}
