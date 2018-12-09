package com.food.foodmicroservicesclient.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultMusic {
	
	private Weather weather;
	private List<Track> tracks;
	
	public ResultMusic() {
		
	}
	
	public ResultMusic(Weather weather, List<Track> tracks) {
		super();
		this.weather = weather;
		this.tracks = tracks;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
}
