package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

}
