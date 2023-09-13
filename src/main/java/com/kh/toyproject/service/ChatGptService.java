package com.kh.toyproject.service;

import java.net.URISyntaxException;

import com.kh.toyproject.vo.ChatGptRequestVO;

public interface ChatGptService {
	String chatRequest(ChatGptRequestVO requestVO) throws URISyntaxException;
}
