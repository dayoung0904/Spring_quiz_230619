package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.weather_history.domain.WeatherHistory;


@Repository
public interface WeatherHistoryMapper {
	
	public List<WeatherHistory> selectWeatherHistory();
		
	public void insertWheatherHistory(
			@Param("date") String date, 
			@Param("weather") String weather, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("microDust") String microDust, 
			@Param("windSpeed") double windSpeed);
	

}
