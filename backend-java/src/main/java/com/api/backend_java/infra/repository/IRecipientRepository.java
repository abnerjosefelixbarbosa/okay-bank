package com.api.backend_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Recipient;

@Repository
public interface IRecipientRepository extends JpaRepository<Recipient, String> {

}
