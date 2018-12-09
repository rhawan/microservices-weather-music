package com.food.foodmicroservicesresourceserver.spotify.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultTracks {

	private List<Tracks> items;

	public ResultTracks() {
	}
	
	public List<Tracks> getItems() {
		return items;
	}

	public void setItems(List<Tracks> items) {
		this.items = items;
	}

	/*@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		items.forEach(i -> strBuild.append(i));
		return "ResultTracks{" + "items=" + strBuild.toString() + "}";
	}*/

}
