package com.food.foodmicroservicesresourceserver.spotify.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaylistTrack {

	private String href;
	private Integer total;

	public PlaylistTrack() {

	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PlaylistTrack={" + "href=" + href + ", total=" + total + "}";
	}

}
