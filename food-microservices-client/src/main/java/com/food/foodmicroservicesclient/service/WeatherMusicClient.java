package com.food.foodmicroservicesclient.service;

import javax.ws.rs.Produces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.foodmicroservicesclient.bean.ResultMusic;

@FeignClient(name = "weather-music-service")
public interface WeatherMusicClient {

	@Produces("application/json")
    @RequestMapping("/musics/{city}")
    ResultMusic getMusicsByCity(@PathVariable("city") String city);
    
    @Produces("application/json")
    @RequestMapping("/musics/{lat}/{long}")
    ResultMusic getWeatherByLatLon(@PathVariable("lat") String lat, @PathVariable("long") String lon);
}