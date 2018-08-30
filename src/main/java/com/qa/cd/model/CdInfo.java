package com.qa.cd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CdInfo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
			
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Artist> artist = new ArrayList<>();	
	
	public CdInfo() {

	}

	public CdInfo (String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}

}
