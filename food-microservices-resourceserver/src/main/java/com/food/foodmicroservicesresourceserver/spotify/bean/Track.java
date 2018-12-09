package com.food.foodmicroservicesresourceserver.spotify.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

	private String name;
	private String preview_url;
	private String track_number;
	private Integer popularity;
	
	public Track() {
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
	
	public String getTrack_number() {
		return track_number;
	}

	public void setTrack_number(String track_number) {
		this.track_number = track_number;
	}

	public Integer getPopularity() {
		return popularity;
	}
	
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	@Override
	public String toString() {
		return "Track={" + "name=" + name + ", preview_url=" + preview_url +
				", track_number=" + track_number + ", popularity=" + popularity + "}";
	}

}
