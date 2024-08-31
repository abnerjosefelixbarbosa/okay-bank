package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;
import com.api.backend_java.infra.entity.Agency;

public interface IAgencyGateway {
	AgencyView create(AgencyDTO dto);
	Agency getByNumber(String number);
}
