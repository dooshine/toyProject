package com.kh.toyproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.weather")
public class WeatherProp {
	private String key;
}
