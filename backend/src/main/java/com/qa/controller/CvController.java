package com.qa.controller;

import com.qa.domain.Cv;
import com.qa.service.CvService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/cvsystem")
@CrossOrigin(origins = "http://localhost:8080")
public class CvController {
	
	@Autowired
	private CvService service;
	
	public CvController(CvService service) {
		this.service = service;
	}

	@GetMapping("/get")
    public List<Cv> getAllCv() {
	    return service.getAllCv();
    }

	@PostMapping("/upload-cv")
	public ResponseEntity<Object> uploadCv(@RequestParam("file")MultipartFile file,
                                           @RequestParam("name") String name){
		return service.uploadCv(file, name);
	}

    @GetMapping("/retrieve/{id}")
    public Cv retrieveFile(@PathVariable String id) {
	    return service.downloadCv(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCv(@PathVariable String id){
	    return service.deleteCv(id);
    }

    @PutMapping("/update-cv/{id}")
    public ResponseEntity<Object> updateCv(@PathVariable String id,
                                           @RequestParam("file") MultipartFile file,
                                           @RequestParam("name") String name) {
        return service.updateCv(id, file, name);
    }
}
