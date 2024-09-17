package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;

public interface IAgencyUsercase {
	AgencyDTO create(CreateAgencyDTO dto);
}