package com.food.foodmicroservicesclient.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.foodmicroservicesclient.bean.ResultMusic;
import com.food.foodmicroservicesclient.bean.WeatherForm;
import com.food.foodmicroservicesclient.service.WeatherMusicClient;

@Controller
public class MusicController {
	
	@Autowired
	private WeatherMusicClient weatherMusicClient;
	
	@PostMapping("/weather")
	public ModelAndView getMusicsByName(@ModelAttribute WeatherForm form) {
		ResultMusic resultMusic = new ResultMusic();
		if (!StringUtils.isEmpty(form.getCity())) {
			resultMusic = weatherMusicClient.getMusicsByCity(form.getCity());
		} else if (StringUtils.isNotEmpty(form.getLat()) && StringUtils.isNotEmpty(form.getLon())) {
			resultMusic = weatherMusicClient.getWeatherByLatLon(form.getLat(), form.getLon());
		}
		ModelAndView mv = new ModelAndView("/tracks");
		mv.addObject("weather", resultMusic);
		
		return mv;
	}
	
	@GetMapping("/")
	public String weatherForm(Model model) {
		model.addAttribute("weather", new WeatherForm());
		return "weather";
	}

}
