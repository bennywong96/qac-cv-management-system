package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.domain.Cv;
import com.qa.repository.ICvRepository;

@Service
public class CvService {

	@Autowired
	private ICvRepository repo;
	
	public Cv uploadCv(Cv cv) {
		return repo.save(cv);
	}
	
	public Cv downloadCv(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteCv(Long id) {
		Cv tempCv = repo.findById(id).get();
		repo.delete(tempCv); 
	}
	
}
