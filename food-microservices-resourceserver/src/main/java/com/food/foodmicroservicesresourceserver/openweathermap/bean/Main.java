package com.food.foodmicroservicesresourceserver.openweathermap.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main implements Serializable {

	private static final long serialVersionUID = 1L;

	private String temp;
	private String temp_min;
	private String temp_max;

	public Main() {

	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}

	public String getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}

	@Override
	public String toString() {
		return "Main{" + "temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + "}";
	}
}
