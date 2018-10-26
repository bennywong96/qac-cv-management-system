package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.domain.Cv;
import com.qa.service.CvService;

@RestController
@RequestMapping("/cvsystem")
public class CvController {
	
	@Autowired
	private CvService service;
	
	public CvController(CvService service) {
		this.service = service;
	}
	
	@GetMapping("/upload-cv/{addcv}")
	@ResponseBody
	public Cv uploadCv(@PathVariable Cv uploadCv) {
		return service.uploadCv(uploadCv);
	}

	@GetMapping("/download-cv/{id}")
	@ResponseBody
	public Cv downloadCv(@PathVariable long id) {
		return service.downloadCv(id);
	}

}
