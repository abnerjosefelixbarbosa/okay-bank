package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.api.backend_java.infra.entity.Agency;

public interface IAgencyGateway {
	AgencyDTO create(CreateAgencyDTO dto);
	Agency getByNumber(String number);
	Agency getById(String id);
}
