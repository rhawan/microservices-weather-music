package com.food.foodmicroservicesclient;

import com.food.foodmicroservicesclient.service.WeatherMusicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@SpringBootApplication
public class FoodMicroservicesClientApplication {

	@Autowired
	private WeatherMusicClient weatherMusicClient;

	public static void main(String[] args) {
		SpringApplication.run(FoodMicroservicesClientApplication.class, args);
	}

	@RequestMapping("/test")
	public String test() {
		return weatherMusicClient.getMusicsBy("GYN");
	}
}
