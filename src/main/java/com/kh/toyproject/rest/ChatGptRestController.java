package com.kh.toyproject.rest;

import com.kh.toyproject.service.ChatGptService;
import com.kh.toyproject.vo.WeatherResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/chat")
public class ChatGptRestController {

	@Autowired
	private ChatGptService gptService;

	@PostMapping("/")
	public String getGpt(@RequestBody WeatherResponseVO vo) throws URISyntaxException {
		return gptService.chatRequest(vo);
	}
}
