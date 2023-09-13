package com.kh.toyproject.vo;

import lombok.Data;
import lombok.Getter;

@Data
public class KarloResponseVO {
	private String id;
	private String meodel_version;
	private Image[] images;
	
	@Getter
	public static class Image {
		private String id;
		private long seed;
		private String image;
		private boolean nsfw_content_detected;
		private double nsfw_score;
	}
}
