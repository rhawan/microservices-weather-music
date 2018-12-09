package com.food.foodmicroservicesresourceserver.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.foodmicroservicesresourceserver.config.property.FoodApiProperty;
import com.food.foodmicroservicesresourceserver.openweathermap.bean.ResultWeather;

@Service
public class WeatherService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private FoodApiProperty foodApiProperty;
	
	public ResultWeather getWeatherByCity(String city) {
		if (StringUtils.isEmpty(city)) {
			throw new IllegalArgumentException("The city name is required");
		}
		String url = String.format("%s%s&q=%s", foodApiProperty.getOpenWeatherURI(), foodApiProperty.getOpenWeatherToken(), city);
    	return this.restTemplate.getForObject(url, ResultWeather.class);
	}
	
	public ResultWeather getWeatherByLatLon(String lat, String lon) {
		if (StringUtils.isEmpty(lat)) {
			throw new IllegalArgumentException("The lat is required");
		}
		if (StringUtils.isEmpty(lon)) {
			throw new IllegalArgumentException("The lon is required");
		}
		String url = String.format("%s%s&lat=%s&lon=%s", foodApiProperty.getOpenWeatherURI(), foodApiProperty.getOpenWeatherToken(), lat, lon);
    	return this.restTemplate.getForObject(url, ResultWeather.class);
	}
	
	public String getPlaylistType(ResultWeather weather) {
		if (weather == null) {
			throw new IllegalArgumentException("weather is required");
		}
		
		double temp = Double.parseDouble(weather.getMain().getTemp());
    	String playlistType = "";
    	if (temp > 30) {
    		playlistType = PlaylistType.PARTY.getPlaylist();
    	} else if (temp >= 15 && temp <= 30) {
    		playlistType = PlaylistType.POP.getPlaylist();
    	} else if (temp >= 10 && temp <= 14) {
    		playlistType = PlaylistType.ROCK.getPlaylist();
    	} else if (temp < 10) {
    		playlistType = PlaylistType.CLASSICAL.getPlaylist();
    	}
    	return playlistType;
	}
	
	enum PlaylistType {
		
		PARTY("party"),
		POP("pop"),
		ROCK("rock"),
		CLASSICAL("classical");
		
		private String playlist;
		
		PlaylistType(String playlist) {
			this.playlist = playlist;
		}
		
		public String getPlaylist() {
			return playlist;
		}
	}

}
