package com.qa.domain;

import java.io.File;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cv {

	@Id
	private Long id;
	private String name;
	private Date lastModified;
	private String cvFile;

	public Cv(String name, String cvFile) {
		this.name = name;
		this.cvFile = cvFile;
	}

	public Cv() {

	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getLastModified() {
		return lastModified;
	}
	
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	public String getCvFile() {
		return cvFile;
	}
	
	public void setCvFile(String cvFile) {
		this.cvFile = cvFile;
	}
	
	
	

}
