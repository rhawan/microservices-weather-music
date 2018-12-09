package com.food.foodmicroservicesresourceserver.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodmicroservicesresourceserver.bean.ResultMusic;
import com.food.foodmicroservicesresourceserver.bean.Track;
import com.food.foodmicroservicesresourceserver.bean.Weather;
import com.food.foodmicroservicesresourceserver.openweathermap.bean.ResultWeather;
import com.food.foodmicroservicesresourceserver.service.SpotifyService;
import com.food.foodmicroservicesresourceserver.service.WeatherService;
import com.food.foodmicroservicesresourceserver.spotify.bean.ResultTracks;

@RestController
public class WeatherMusicController {
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private SpotifyService spotifyService;


	@Produces("application/json")
    @RequestMapping("/musics/{city}")
    public ResultMusic getMusicsByCity(@PathVariable("city") String city) throws UnsupportedEncodingException {
    	// https://github.com/ifood/ifood-backend-advanced-test
    	// https://openweathermap.org/current
    	// https://developer.spotify.com/console/get-category-playlists/?category_id=party&country=BR&limit=1&offset=
    	// https://developer.spotify.com/console/get-playlist-tracks/
    	// https://developer.spotify.com/documentation/general/guides/authorization-guide/
    	
    	ResultWeather resultWeather = weatherService.getWeatherByCity(city);
    	String playlistType = weatherService.getPlaylistType(resultWeather);
    	
    	ResultTracks resultTracks = spotifyService.getTrackList(playlistType);
    	
    	List<Track> tracks = new ArrayList<>();
    	resultTracks.getItems().forEach(i -> {
    		tracks.add(new Track(i.getTrack().getName(), i.getTrack().getPreview_url()));
    	});
    	Weather weather = new Weather(resultWeather.getMain().getTemp(), resultWeather.getWeather().get(0).getDescription());
    	
    	return new ResultMusic(weather, tracks);
    }
	
	@Produces("application/json")
    @RequestMapping("/musics/{lat}/{long}")
    public ResultMusic getWeatherByLatLon(@PathVariable("lat") String lat, @PathVariable("long") String lon) throws UnsupportedEncodingException {
    	ResultWeather resultWeather = weatherService.getWeatherByLatLon(lat, lon);
    	String playlistType = weatherService.getPlaylistType(resultWeather);
    	
    	ResultTracks resultTracks = spotifyService.getTrackList(playlistType);
    	
    	List<Track> tracks = new ArrayList<>();
    	resultTracks.getItems().forEach(i -> {
    		tracks.add(new Track(i.getTrack().getName(), i.getTrack().getPreview_url()));
    	});
    	Weather weather = new Weather(resultWeather.getMain().getTemp(), resultWeather.getWeather().get(0).getDescription());
    	
    	return new ResultMusic(weather, tracks);
    }

}
