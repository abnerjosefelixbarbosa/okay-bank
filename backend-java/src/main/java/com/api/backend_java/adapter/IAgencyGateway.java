package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;

public interface IAgencyGateway {
	AgencyView create(AgencyDTO dto);
}
