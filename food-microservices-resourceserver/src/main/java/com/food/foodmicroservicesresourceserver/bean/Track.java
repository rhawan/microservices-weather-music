package com.food.foodmicroservicesresourceserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
	
	private String name;
	private String preview_url;
	
	public Track(String name, String preview_url) {
		super();
		this.name = name;
		this.preview_url = preview_url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	
	

}
