package com.kh.toyproject;

import com.kh.toyproject.vo.KarloResponseVO;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
public class KarloTest {
	@Value("${kakao-api-key}")
	private String kakaoApiKey;
	
	@Autowired
	private RestTemplate template;
	
    @Test
    void karloTest() throws URISyntaxException {
    	URI uri = new URI("https://api.kakaobrain.com/v2/inference/karlo/t2i");
    	HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoApiKey);
		headers.add("Content-Type", "application/json");
    	
		String prompt = "A cat with white fur";
		JSONObject body = new JSONObject();
        body.put("prompt", prompt);
//        body.put("prompt2", "A cat with white fur");
        body.put("negative_prompt", "sleeping cat, dog, human, ugly face, cropped");
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
        
        
        KarloResponseVO responseVO = template.postForObject(uri, requestEntity, KarloResponseVO.class);
//        System.out.println(body);
        
    }
}
