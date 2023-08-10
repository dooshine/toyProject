package com.kh.toyproject.vo;

import lombok.Data;

@Data
public class WeatherRequestVO {
	private int numOfRows;
	private int pageNo;
	private String dataType;
	private int base_date;
	private int base_time;
	private int nx;
	private int ny;
}
