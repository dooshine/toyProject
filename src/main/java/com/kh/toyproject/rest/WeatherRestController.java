package com.kh.toyproject.rest;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{nx}/{ny}")
	public WeatherResponseVO getWeather(@PathVariable int nx, @PathVariable int ny) throws URISyntaxException{
		return weatherService.request(nx, ny);
	}
}
