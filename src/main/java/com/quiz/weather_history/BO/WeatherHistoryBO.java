package com.quiz.weather_history.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistory() {
		
		return weatherHistoryMapper.selectWeatherHistory();
	}

	public void addWheatherHistory(String date, String weather, double temperatures, 
			double precipitation, String microDust, double windSpeed) {
		
		weatherHistoryMapper.insertWheatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
