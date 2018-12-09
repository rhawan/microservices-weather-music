package com.food.foodmicroservicesresourceserver.openweathermap.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultWeather implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Weather> weather;
	private Main main;

	public ResultWeather() {
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		weather.forEach(w -> strBuild.append(w));
		return "ResultWeather{" + "main=" + main + ", weather=[" + strBuild.toString() + "}";
	}

}
