package com.org.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.interfaces.TelephoneMethods;
import com.org.backend.models.TelephoneModel;
import com.org.backend.repositories.TelephoneRepository;

@Service
public class TelephoneService {
	@Autowired
	private TelephoneRepository telephoneRepository;

	public List<TelephoneModel> findAll() {
		List<TelephoneModel> telephoneModels = telephoneRepository.findAll();
		return telephoneModels;
	}

	public TelephoneModel findById(String id) {
		return telephoneRepository.findById(id).orElseThrow(() -> {
			return new EntityNotFoundException("id not found");
		});
	}

	public String save(TelephoneModel telephoneModel) {
		telephoneRepository.save(telephoneModel);
		return "telephone saved";
	}

}
