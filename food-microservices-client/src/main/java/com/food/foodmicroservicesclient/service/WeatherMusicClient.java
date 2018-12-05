package com.food.foodmicroservicesclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("weather-music-service")
public interface WeatherMusicClient {

    @RequestMapping("/musics/{city}")
    String getMusicsBy(@PathVariable("city") String city);
}
