package com.food.foodmicroservicesresourceserver.spotify.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {

	private String id;
	private String name;
	private PlaylistTrack tracks;

	public Playlist() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlaylistTrack getTracks() {
		return tracks;
	}

	public void setTracks(PlaylistTrack tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Playlist{" + "id=" + id + ", name=" + name + ", tracks=" + tracks + "}";
	}

}
