package com.org.back_end_java.infra.service;

import com.org.back_end_java.infra.entity.Agency;

public interface IAgencyService {
	Agency save(Agency agency);
	boolean existsAgency(Agency agency);
}
