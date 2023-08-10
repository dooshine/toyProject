package com.kh.toyproject.service;

import java.net.URISyntaxException;
import java.util.List;

import com.kh.toyproject.vo.WeatherRequestVO;
import com.kh.toyproject.vo.WeatherResponseVO;

public interface WeatherService {
	WeatherResponseVO request(WeatherRequestVO weatherRequestVO) throws URISyntaxException;
}
