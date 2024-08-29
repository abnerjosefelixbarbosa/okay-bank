package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.AgencyView;

public interface IAgencyUsercase {
	AgencyView create(AgencyDTO dto);
}