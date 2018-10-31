package com.qa.domain;

import java.util.Date;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Cv {

	@Id
	private String id;
	@Field
	private String name;
	@Field
	private Date lastModified;
	@Field
	private Binary cvFile;

	public Cv(String name, Binary cvFile) {
		this.name = name;
		this.cvFile = cvFile;
	}

	public Cv(String name){
	    this.name = name;
    }

    public Cv() {}

    public String getId() {
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

    public Binary getCvFile() {
        return cvFile;
    }

    public void setCvFile(Binary cvFile) {
        this.cvFile = cvFile;
    }

}
