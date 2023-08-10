package com.kh.toyproject.service;

import java.net.URISyntaxException;

import com.kh.toyproject.vo.WeatherResponseVO;

public interface ChatGptService {
	String chatRequest(WeatherResponseVO weatherVO) throws URISyntaxException;
}
