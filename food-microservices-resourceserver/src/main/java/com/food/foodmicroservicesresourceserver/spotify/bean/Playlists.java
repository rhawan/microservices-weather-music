package com.food.foodmicroservicesresourceserver.spotify.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlists {

	private List<Playlist> items;

	public Playlists() {
	}

	public List<Playlist> getItems() {
		return items;
	}

	public void setItems(List<Playlist> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		items.forEach(i -> strBuild.append(i));
		return "Playlists{" + "items=" + strBuild.toString() + "}";
	}

}
