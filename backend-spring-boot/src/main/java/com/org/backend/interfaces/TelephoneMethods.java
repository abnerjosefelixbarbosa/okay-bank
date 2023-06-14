package com.org.backend.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.org.backend.models.TelephoneModel;

@Repository
public interface TelephoneMethods {
	List<TelephoneModel> findAll();

	TelephoneModel findById(String id);

	String save(TelephoneModel telephoneModel);
}
