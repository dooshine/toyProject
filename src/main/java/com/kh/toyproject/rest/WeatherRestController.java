package com.kh.toyproject.rest;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.toyproject.service.WeatherService;
import com.kh.toyproject.vo.WeatherRequestVO;
import com.kh.toyproject.vo.WeatherResponseVO;

@RestController
@RequestMapping("/weather")
public class WeatherRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
	public WeatherResponseVO getWeather(WeatherRequestVO vo) throws URISyntaxException{
		return weatherService.request(vo);
	}
}
