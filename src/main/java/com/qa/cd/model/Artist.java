package com.qa.cd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "Artist")
@Table (name = "Artist")
public class Artist {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
	public Artist() {
	}	
	public Artist (String artist) {
		this.name = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String artist) {
		this.name = artist;
	}
	
}
