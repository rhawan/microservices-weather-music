package com.food.foodmicroservicesresourceserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherMusicController {

    @RequestMapping("/musics/{city}")
    public String getMusicsBy(@PathVariable("city") String city) {
        return "AC/DC yeah!";
    }

}
