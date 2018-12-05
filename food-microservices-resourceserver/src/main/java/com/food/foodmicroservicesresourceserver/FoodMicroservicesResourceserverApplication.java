package com.food.foodmicroservicesresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodMicroservicesResourceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMicroservicesResourceserverApplication.class, args);
	}
}
