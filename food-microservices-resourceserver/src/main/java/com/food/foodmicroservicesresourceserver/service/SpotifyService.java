package com.food.foodmicroservicesresourceserver.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.food.foodmicroservicesresourceserver.config.property.FoodApiProperty;
import com.food.foodmicroservicesresourceserver.spotify.bean.OAuthToken;
import com.food.foodmicroservicesresourceserver.spotify.bean.ResultPlaylists;
import com.food.foodmicroservicesresourceserver.spotify.bean.ResultTracks;

@Service
public class SpotifyService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private FoodApiProperty foodApiProperty;
	
	private OAuthToken getAccessToken() throws UnsupportedEncodingException {		
    	String urlTokenSpotify = foodApiProperty.getSpotifyOAuthURI();
    	String clientId = foodApiProperty.getSpotifyClientId();
    	String clientSecret = foodApiProperty.getSpotifyClientSecret();    	
    	String credentials = Base64.getEncoder().encodeToString(String.format("%s:%s", clientId, clientSecret).getBytes("utf-8"));
    	
    	HttpHeaders headersToken = new HttpHeaders();
    	headersToken.add("Content-Type", "application/x-www-form-urlencoded");
    	headersToken.add("Authorization", String.format("Basic %s", credentials));
    	
    	MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    	map.add("grant_type", "client_credentials");
    	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headersToken);
    	
    	return restTemplate.postForEntity(urlTokenSpotify, request, OAuthToken.class).getBody();
	}
	
	public ResultTracks getTrackList(String playlist) throws UnsupportedEncodingException {
		HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "Bearer " + getAccessToken().getAccess_token());
    	HttpEntity<ResultPlaylists> entity = new HttpEntity<ResultPlaylists>(headers);
   
    	String url = foodApiProperty.getSpotifyPlaylistsURI().replace("{genre}", playlist);
    	ResponseEntity<ResultPlaylists> resultPlaylist = restTemplate.exchange(url, HttpMethod.GET, entity, ResultPlaylists.class);
    	
    	HttpEntity<ResultTracks> entityTracks = new HttpEntity<ResultTracks>(headers);
    	return restTemplate.exchange(
    			resultPlaylist.getBody().getPlaylists().getItems().get(0).getTracks().getHref(),
    			HttpMethod.GET, entityTracks, ResultTracks.class).getBody();
	}

}
