package com.kh.toyproject.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.toyproject.vo.KarloResponseVO;

@Service
public class KarloServiceImpl implements KarloService{
	@Value("${kakao-api-key}")
	private String kakaoApiKey;
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public KarloResponseVO KarloResponse(String prompt) throws URISyntaxException {
		URI uri = new URI("https://api.kakaobrain.com/v2/inference/karlo/t2i");
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoApiKey);
		headers.add("Content-Type", "application/json");
    	
		JSONObject body = new JSONObject();
        body.put("prompt", prompt);
        body.put("negative_prompt", "sleeping cat, dog, human, ugly face, cropped");
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
        
        
        KarloResponseVO responseVO = template.postForObject(uri, requestEntity, KarloResponseVO.class);
		return responseVO;
	}
	
}
