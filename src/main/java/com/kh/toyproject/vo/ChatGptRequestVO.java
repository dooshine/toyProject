package com.kh.toyproject.vo;

import lombok.Data;

@Data
public class ChatGptRequestVO {
	private double temp;
	private double rainAmount;
	private int rainType;
	private double humid;
	private double wind;
	private String gender;
}
