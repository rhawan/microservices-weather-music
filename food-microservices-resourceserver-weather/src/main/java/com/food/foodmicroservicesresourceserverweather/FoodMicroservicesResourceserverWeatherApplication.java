package com.food.foodmicroservicesresourceserverweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodMicroservicesResourceserverWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMicroservicesResourceserverWeatherApplication.class, args);
	}
}
