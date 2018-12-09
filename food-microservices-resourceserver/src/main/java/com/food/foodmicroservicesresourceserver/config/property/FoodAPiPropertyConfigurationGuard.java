package com.food.foodmicroservicesresourceserver.config.property;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodAPiPropertyConfigurationGuard implements InitializingBean {

	@Autowired
	private FoodApiProperty foodApiProperty;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isEmpty(foodApiProperty.getOpenWeatherURI())) {
			throw new IllegalArgumentException("${food.openWeatherURI} must be configured");
		}
		if (StringUtils.isEmpty(foodApiProperty.getOpenWeatherToken())) {
			throw new IllegalArgumentException("${food.openWeatherToken} must be configured");
		}

		if (StringUtils.isEmpty(foodApiProperty.getSpotifyClientId())) {
			throw new IllegalArgumentException("${food.spotifyClientId} must be configured");
		}
		if (StringUtils.isEmpty(foodApiProperty.getSpotifyClientSecret())) {
			throw new IllegalArgumentException("${food.spotifyClientSecret} must be configured");
		}

		if (StringUtils.isEmpty(foodApiProperty.getSpotifyOAuthURI())) {
			throw new IllegalArgumentException("${food.spotifyOAuthURI} must be configured");
		}

		if (StringUtils.isEmpty(foodApiProperty.getSpotifyPlaylistsURI())) {
			throw new IllegalArgumentException("${food.spotifyPlaylistsURI} must be configured");
		}
	}

}
