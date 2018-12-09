package com.food.foodmicroservicesclient.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	
	private String temp;
	private String description;
	
	public Weather() {
		
	}
	
	public Weather(String temp, String description) {
		super();
		this.temp = temp;
		this.description = description;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
