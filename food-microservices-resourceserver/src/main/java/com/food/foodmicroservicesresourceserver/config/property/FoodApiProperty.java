package com.food.foodmicroservicesresourceserver.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("food")
public class FoodApiProperty {
	
	private String openWeatherURI;
	private String openWeatherToken;
	
	private String spotifyOAuthURI;
	private String spotifyClientId;
	private String spotifyClientSecret;
	private String spotifyPlaylistsURI;
	
	public String getOpenWeatherURI() {
		return openWeatherURI;
	}
	public void setOpenWeatherURI(String openWeatherURI) {
		this.openWeatherURI = openWeatherURI;
	}
	public String getOpenWeatherToken() {
		return openWeatherToken;
	}
	public void setOpenWeatherToken(String openWeatherToken) {
		this.openWeatherToken = openWeatherToken;
	}
	public String getSpotifyOAuthURI() {
		return spotifyOAuthURI;
	}
	public void setSpotifyOAuthURI(String spotifyOAuthURI) {
		this.spotifyOAuthURI = spotifyOAuthURI;
	}
	public String getSpotifyClientId() {
		return spotifyClientId;
	}
	public void setSpotifyClientId(String spotifyClientId) {
		this.spotifyClientId = spotifyClientId;
	}
	public String getSpotifyClientSecret() {
		return spotifyClientSecret;
	}
	public void setSpotifyClientSecret(String spotifyClientSecret) {
		this.spotifyClientSecret = spotifyClientSecret;
	}
	public String getSpotifyPlaylistsURI() {
		return spotifyPlaylistsURI;
	}
	public void setSpotifyPlaylistsURI(String spotifyPlaylistsURI) {
		this.spotifyPlaylistsURI = spotifyPlaylistsURI;
	}
	
}
