package com.org.back_end_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.back_end_java.infra.entity.Agency;

@Repository
public interface IAgencyRepository extends JpaRepository<Agency, String> {

}
