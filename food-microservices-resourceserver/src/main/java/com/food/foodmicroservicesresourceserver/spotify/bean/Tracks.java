package com.food.foodmicroservicesresourceserver.spotify.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracks {

	private Track track;

	public Tracks() {
	}
	
	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	/*@Override
	public String toString() {
		return "Tracks{" + "track=" + track + "}";
	}*/

}
