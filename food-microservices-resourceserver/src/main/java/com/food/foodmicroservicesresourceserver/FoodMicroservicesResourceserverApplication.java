package com.food.foodmicroservicesresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.food.foodmicroservicesresourceserver.config.property.FoodApiProperty;

@EnableDiscoveryClient
@EnableConfigurationProperties(FoodApiProperty.class)
@SpringBootApplication
public class FoodMicroservicesResourceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMicroservicesResourceserverApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
