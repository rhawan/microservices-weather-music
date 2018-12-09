package com.food.foodmicroservicesresourceserver.spotify.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultPlaylists {

	private Playlists playlists;

	public ResultPlaylists() {
	}

	public Playlists getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "ResultPlaylists{" + "playlists=" + playlists + "}";
	}

}
