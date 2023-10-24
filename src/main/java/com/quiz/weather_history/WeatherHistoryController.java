package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.BO.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면
	@GetMapping("/weather-history")
	public String weatherHistory(Model model) {
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		return "weather_history/wetherHistory";
	}
	
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView(){
		
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 로직
	@PostMapping("/add-weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-mm-dd") Date date) {
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		// db insert
		weatherHistoryBO.addWheatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		// response
		// redirect => history page
		return "redirect:/weather-history";
	}
}
